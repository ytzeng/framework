package org.leo.zeng.api.support;

import org.leo.zeng.api.pojo.ResponseDto;
import org.leo.zeng.api.pojo.ResponseHeadDto;
import org.leo.zeng.core.consts.MessageCode;
import org.leo.zeng.core.exception.ClientException;
import org.leo.zeng.core.exception.ServiceException;
import org.leo.zeng.core.support.MessageSourceAccessor;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseRescouce {
    @Autowired
    protected MessageSourceAccessor msa;

    protected ResponseDto success() {
        ResponseDto response = new ResponseDto();
        response.setHead(new ResponseHeadDto(MessageCode.SUCCESS, msa.getMessage(MessageCode.SUCCESS)));
        return response;
    }

    protected ResponseDto success(Object body) {
        ResponseDto response = new ResponseDto();
        response.setHead(new ResponseHeadDto(MessageCode.SUCCESS, msa.getMessage(MessageCode.SUCCESS)));
        response.setBody(body);
        return response;
    }

    protected ResponseDto success(ResponseHeadDto head, Object body) {
        ResponseDto response = new ResponseDto();
        response.setHead(head);
        response.setBody(body);
        return response;
    }

    protected ResponseDto failure(Throwable e, String code, Logger logger) {
        if (e instanceof ClientException) {
            logger.error(e.getMessage());
            return failure((ClientException) e);
        } else if (e instanceof ServiceException) {
            logger.error(e.getMessage());
            return failure(code);
        } else {
            logger.error(e.getMessage(), e);
            return error();
        }
    }

    private ResponseDto failure(ClientException e) {
        ResponseDto response = new ResponseDto();
        response.setHead(new ResponseHeadDto(e.getMsg()));
        return response;
    }

    private ResponseDto failure(String code) {
        ResponseDto response = new ResponseDto();
        String name = msa.getMessage(code);
        response.setHead(new ResponseHeadDto(MessageCode.S9998, msa.getMessage(MessageCode.S9998, name)));
        return response;
    }

    private ResponseDto error() {
        ResponseDto response = new ResponseDto();
        response.setHead(new ResponseHeadDto(MessageCode.S9999, msa.getMessage(MessageCode.S9999)));
        return response;
    }
}
