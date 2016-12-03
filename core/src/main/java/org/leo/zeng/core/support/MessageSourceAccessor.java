package org.leo.zeng.core.support;

import org.springframework.context.MessageSource;

public class MessageSourceAccessor {

    private MessageSource messageSource;

    public MessageSourceAccessor(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessage(String code, Object... args) {
        return this.messageSource.getMessage(code, args, null);
    }

    public String getMessage(String code, String... args) {
        return this.messageSource.getMessage(code, args, null);
    }
}
