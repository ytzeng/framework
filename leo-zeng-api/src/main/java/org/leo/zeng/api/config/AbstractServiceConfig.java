package org.leo.zeng.api.config;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.message.GZipEncoder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.EncodingFilter;
import org.leo.zeng.api.filter.ServiceLogFilter;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public abstract class AbstractServiceConfig extends ResourceConfig {
    public AbstractServiceConfig() {
        super();
        // 注册资源调用日志过滤器
        register(new ServiceLogFilter());
        // 注册JSON支持
        register(JacksonJsonProvider.class);
        register(JacksonFeature.class);
        register(MultiPartFeature.class);
        // 资源注册
        packages(packages());
        // 注册gzip压缩支持
        EncodingFilter.enableFor(this, GZipEncoder.class);
    }

    public abstract String[] packages();
}
