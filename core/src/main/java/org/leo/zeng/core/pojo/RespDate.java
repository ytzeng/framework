package org.leo.zeng.core.pojo;

@SuppressWarnings("serial")
public class RespDate extends BaseObject {
    /** 返回码 */
    private String code;
    /** 返回消息 */
    private String message;
    /** 返回数据 */
    private Object data;

    public RespDate() {
        this(new MsgInfo());
    }

    public RespDate(MsgInfo msg) {
        this(msg.getCode(), msg.getMessage());
    }

    public RespDate(String code, String message) {
        this(code, message, null);
    }

    public RespDate(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
