package org.leo.zeng.core.exception;

import org.leo.zeng.core.pojo.MsgInfo;

@SuppressWarnings("serial")
public class ClientException extends ServiceException {

    public ClientException(MsgInfo msg, Throwable cause) {
        super(msg, cause);
    }

    public ClientException(MsgInfo msg) {
        super(msg);
    }

    public ClientException(String code, String msg, Throwable cause) {
        super(code, msg, cause);
    }

    public ClientException(String code, String msg) {
        super(code, msg);
    }

}
