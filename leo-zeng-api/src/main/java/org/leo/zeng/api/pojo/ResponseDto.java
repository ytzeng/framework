package org.leo.zeng.api.pojo;

import org.leo.zeng.core.pojo.BaseObject;

@SuppressWarnings("serial")
public class ResponseDto extends BaseObject {
    /** 响应头 */
    private ResponseHeadDto head;
    /** 响应体 */
    private Object body;

    public ResponseHeadDto getHead() {
        return head;
    }

    public void setHead(ResponseHeadDto head) {
        this.head = head;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
