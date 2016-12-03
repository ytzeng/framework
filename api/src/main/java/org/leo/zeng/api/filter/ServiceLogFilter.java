package org.leo.zeng.api.filter;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Map;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceLogFilter implements ContainerRequestFilter {
    private Logger logger;
    private static final String NOTIFICATION_PREFIX = "* ";
    private static final String REQUEST_PREFIX = "> ";

    public ServiceLogFilter() {
        this(LoggerFactory.getLogger(ServiceLogFilter.class));
    }

    public ServiceLogFilter(Logger logger) {
        this.logger = logger;
    }

    public void filter(ContainerRequestContext requestContext) throws IOException {
        final StringBuilder b = new StringBuilder();
        b.append("\n");
        printRequestLine(b, "Server has received a request", requestContext.getMethod(), requestContext.getUriInfo().getRequestUri());
        printPrefixedHeaders(b, REQUEST_PREFIX, requestContext.getHeaders());
        logger.info(b.toString());
    }

    private void printRequestLine(final StringBuilder b, final String note, final String method, final URI uri) {
        b.append(NOTIFICATION_PREFIX).append(note).append(" on thread ").append(Thread.currentThread().getName()).append("\n");
        b.append(REQUEST_PREFIX).append(method).append(" ").append(uri.toASCIIString()).append("\n");
    }

    private void printPrefixedHeaders(final StringBuilder b, final String prefix, final MultivaluedMap<String, String> headers) {
        for (final Map.Entry<String, List<String>> headerEntry : headers.entrySet()) {
            final List<?> val = headerEntry.getValue();
            final String header = headerEntry.getKey();

            if (val.size() == 1) {
                b.append(prefix).append(header).append(": ").append(val.get(0)).append("\n");
            } else {
                final StringBuilder sb = new StringBuilder();
                boolean add = false;
                for (final Object s : val) {
                    if (add) {
                        sb.append(',');
                    }
                    add = true;
                    sb.append(s);
                }
                b.append(prefix).append(header).append(": ").append(sb.toString()).append("\n");
            }
        }
    }

}
