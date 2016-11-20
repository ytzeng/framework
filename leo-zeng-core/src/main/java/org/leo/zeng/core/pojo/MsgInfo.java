package org.leo.zeng.core.pojo;

public class MsgInfo {
    private String field;
    private String code;
    private String message;

    public MsgInfo(String field, String code, String message) {
        this.field = field;
        this.code = code;
        this.message = message;
    }

    public MsgInfo(String code, String message) {
        this(null, code, message);
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
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

    public String toString() {
        return this.code + ":" + this.message;
    }

}
