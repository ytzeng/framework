package org.leo.zeng.api.proxy;

import org.leo.zeng.api.invoker.ServiceInvoker;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class HttpServiceProxy extends ServiceProxy {
    protected String basePath;
    @Autowired
    protected ServiceInvoker invoker;
}
