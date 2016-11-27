package org.leo.zeng.api.invoker;

import org.leo.zeng.api.pojo.ServiceRequest;
import org.leo.zeng.api.pojo.ServiceResponse;

public interface Invoker {

    public <Req extends ServiceRequest, Resp extends ServiceResponse> Resp invoke(String url, Req req, Class<Resp> clazz);

}
