package org.leo.zeng.core.pojo;

@SuppressWarnings("serial")
public class JsonModel extends BaseObject {
    /** 返回码 */
    private String code;
    /** 返回消息 */
    private String message;
    /** 返回数据 */
    private BaseObject data;

    public JsonModel() {
        super();
    }

    public JsonModel(MsgInfo msg) {
        super();
        this.code = msg.getCode();
        this.message = msg.getMessage();
    }

    public JsonModel(String code, String message) {
        this(code, message, null);
    }

    public JsonModel(String code, String message, BaseObject data) {
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

    public BaseObject getData() {
        return data;
    }

    public void setData(BaseObject data) {
        this.data = data;
    }
}
