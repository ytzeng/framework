package org.leo.zeng.api.pojo;

import org.leo.zeng.core.consts.MessageCode;
import org.leo.zeng.core.pojo.BaseObject;
import org.leo.zeng.core.pojo.MsgInfo;

@SuppressWarnings("serial")
public class ResponseHeadDto extends BaseObject {
    /** 返回码 */
    private String code;

    /** 返回消息 */
    private String message;

    public ResponseHeadDto() {
        this(MessageCode.S9999, MessageCode.DEFAULT_ERROR);
    }

    public ResponseHeadDto(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseHeadDto(MsgInfo msg) {
        this.code = msg.getCode();
        this.message = msg.getMessage();
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
}
