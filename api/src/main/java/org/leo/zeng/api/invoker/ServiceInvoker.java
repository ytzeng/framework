package org.leo.zeng.api.invoker;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;
import org.leo.zeng.api.pojo.ServiceRequest;
import org.leo.zeng.api.pojo.ServiceResponse;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@Component
public class ServiceInvoker implements Invoker {
    private Client client;

    public ServiceInvoker() {
        client = ClientBuilder.newClient(new ClientConfig().register(JacksonJsonProvider.class));
    }

    public <Req extends ServiceRequest, Resp extends ServiceResponse> Resp invoke(String url, Req req, Class<Resp> clazz) {
        Response response = client.target(url).request().buildPost(Entity.entity(req, MediaType.APPLICATION_JSON)).invoke();
        Resp resp = response.readEntity(clazz);
        response.close();
        return resp;
    }
}
