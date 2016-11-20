package org.leo.zeng.core.pojo;

import java.io.Serializable;
import org.leo.zeng.core.util.JsonUtil;

@SuppressWarnings("serial")
public class BaseObject implements Serializable {
    public String toJson() {
        return JsonUtil.toJson(this);
    }

    public String toJsonp(String function) {
        return JsonUtil.toJsonp(function, this);
    }
}
