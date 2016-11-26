package org.leo.zeng.core.pojo;

@SuppressWarnings("serial")
public class RespDate extends BaseObject {
    /** 返回码 */
    private String code;
    /** 返回消息 */
    private String message;
    /** 返回数据 */
    private BaseView response;

    public RespDate() {
        this(new MsgInfo());
    }

    public RespDate(MsgInfo msg) {
        this(msg.getCode(), msg.getMessage());
    }

    public RespDate(String code, String message) {
        this(code, message, null);
    }

    public RespDate(String code, String message, BaseView response) {
        this.code = code;
        this.message = message;
        this.response = response;
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

    public BaseView getResponse() {
        return response;
    }

    public void setResponse(BaseView response) {
        this.response = response;
    }
}
