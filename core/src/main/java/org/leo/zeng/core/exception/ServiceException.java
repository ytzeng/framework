package org.leo.zeng.core.exception;

import org.leo.zeng.core.pojo.MsgInfo;

@SuppressWarnings("serial")
public class ServiceException extends RuntimeException {

    private MsgInfo msg;

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(MsgInfo msg) {
        super(msg.toString());
        this.msg = msg;
    }

    public ServiceException(String code, String msg) {
        this(new MsgInfo(code, msg));
    }

    public ServiceException(MsgInfo msg, Throwable cause) {
        super(msg.toString(), cause);
        this.msg = msg;
    }

    public ServiceException(String code, String msg, Throwable cause) {
        this(new MsgInfo(code, msg), cause);
    }

    public MsgInfo getMsg() {
        return msg;
    }

    @Override
    public String getMessage() {
        if (msg != null) {
            return msg.toString();
        }
        return super.getMessage();
    }
}
