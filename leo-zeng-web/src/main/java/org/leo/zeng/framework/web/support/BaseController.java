package org.leo.zeng.framework.web.support;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.leo.zeng.core.config.SecurityConfig;
import org.leo.zeng.core.config.SysConfig;
import org.leo.zeng.core.consts.MessageCode;
import org.leo.zeng.core.enums.ClientType;
import org.leo.zeng.core.enums.Regular;
import org.leo.zeng.core.exception.ClientException;
import org.leo.zeng.core.exception.ServiceException;
import org.leo.zeng.core.pojo.BaseObject;
import org.leo.zeng.core.pojo.JsonModel;
import org.leo.zeng.core.pojo.MsgInfo;
import org.leo.zeng.core.pojo.UserInfo;
import org.leo.zeng.core.support.MessageSourceAccessor;
import org.leo.zeng.core.util.SpringUtil;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class BaseController {
    @Autowired
    protected MessageSourceAccessor msa;
    @Autowired
    protected SysConfig sysConfig;

    protected JsonModel success(BaseObject data) {
        JsonModel view = new JsonModel(MessageCode.SUCCESS, msa.getMessage(MessageCode.SUCCESS));
        view.setData(data);
        return view;
    }

    protected JsonModel success(MsgInfo msg, BaseObject data) {
        JsonModel view = new JsonModel(msg.getCode(), msg.getMessage());
        view.setData(data);
        return view;
    }

    protected JsonModel failure(Throwable e, String code) {
        if (e instanceof ClientException) {
            return failure((ClientException) e);
        } else if (e instanceof ServiceException) {
            return failure(code);
        } else {
            return error();
        }
    }

    private JsonModel failure(ClientException e) {
        return new JsonModel(e.getMsg());
    }

    private JsonModel failure(String code) {
        JsonModel view = new JsonModel();
        String name = msa.getMessage(code);
        view.setCode(MessageCode.S9998);
        view.setMessage(msa.getMessage(MessageCode.S9998, name));
        return view;
    }

    private JsonModel error() {
        return new JsonModel(MessageCode.S9999, msa.getMessage(MessageCode.S9999));
    }

    protected void log(Throwable e, Logger logger) {
        if (e instanceof ServiceException) {
            logger.error(e.getMessage());
        } else {
            logger.error(e.getMessage(), e);
        }
    }

    protected String redirect(String path, String... params) {
        String result = "redirect:" + path;
        if (params != null && params.length > 0) {
            result += "?";
            for (int i = 0; i < params.length; i++) {
                result += params[i];
                if (i != params.length - 1) {
                    result += "&";
                }
            }
        }
        return result;
    }

    protected HttpServletRequest getRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            return attributes.getRequest();
        }
        return null;
    }

    protected HttpServletResponse getResponse() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            return attributes.getResponse();
        }
        return null;
    }

    protected HttpSession getSession() {
        HttpServletRequest request = getRequest();
        if (request != null) {
            return request.getSession();
        }
        return null;
    }

    protected Locale getLocale() {
        HttpServletRequest request = getRequest();
        if (request != null) {
            return request.getLocale();
        }
        return null;
    }

    protected ClientType getClientType() {
        HttpServletRequest request = getRequest();
        SysConfig config = SpringUtil.getBean(SysConfig.class);
        String appPrefix = config.getAppPrefix();
        String userAgent = request.getHeader("USER-AGENT").toLowerCase();
        if (StringUtils.startsWith(userAgent, appPrefix + "/")) {
            return ClientType.APP;
        }
        Matcher mobile = Regular.USER_AGENT_MOBILE.pattern(Pattern.CASE_INSENSITIVE).matcher(userAgent);
        if (mobile.find()) {
            return ClientType.MOBILE;
        }
        Matcher tablet = Regular.USER_AGENT_TABLET.pattern(Pattern.CASE_INSENSITIVE).matcher(userAgent);
        if (tablet.find()) {
            return ClientType.TABLET;
        }
        return ClientType.UNKNOWN;
    }

    protected UserInfo getUserInfo() throws ClientException {
        UserInfo user = (UserInfo) getSession().getAttribute(SecurityConfig.USER_INFO);
        if (user == null) {
            throw new ClientException(MessageCode.S9997, msa.getMessage(MessageCode.S9997));
        }
        return user;
    }

    protected String getCaptcha() {
        return (String) getSession().getAttribute(SecurityConfig.CAPTCHA);
    }

    protected String getBasePath() {
        HttpServletRequest request = getRequest();
        int port = request.getServerPort();
        String basePath = request.getScheme() + "://" + request.getServerName();
        if (port != 80) {
            basePath += ":" + port;
        }
        basePath += request.getContextPath();
        return basePath + "/";
    }

    protected String getPath(String path) {
        if (StringUtils.isBlank(path)) {
            return path;
        } else if (!path.startsWith("http")) {
            return getBasePath() + path;
        } else {
            return path;
        }
    }

    protected String getDomain() {
        return getRequest().getServerName();
    }

    protected String getHttpDomain() {
        return getRequest().getScheme() + "://" + getRequest().getServerName();
    }

    protected String getIP() {
        HttpServletRequest request = getRequest();
        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isNotBlank(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            if (ip.indexOf("::ffff:") != -1)
                ip = ip.replace("::ffff:", "");
            int index = ip.indexOf(",");
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if (StringUtils.isNotBlank(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            return ip;
        }
        return request.getRemoteAddr();
    }

    protected boolean isAjax() {
        HttpServletRequest request = getRequest();
        String header = request.getHeader("X-Requested-With");
        return StringUtils.isNotBlank(header) && "XMLHttpRequest".equals(header);
    }
}
