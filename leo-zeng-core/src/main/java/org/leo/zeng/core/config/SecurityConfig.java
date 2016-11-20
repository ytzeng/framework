package org.leo.zeng.core.config;

import java.util.List;
import java.util.Map;

public class SecurityConfig {
    public final static String USER_INFO = "userInfo";
    public final static String CAPTCHA = "captcha";
    public final static String GO_URL = "goUrl";
    private Map<String, String> config;
    private List<String> noCaches;
    private List<String> anonymous;
    private String login;
    private Boolean advanced = false;

    public Map<String, String> getConfig() {
        return config;
    }

    public void setConfig(Map<String, String> config) {
        this.config = config;
    }

    public List<String> getNoCaches() {
        return noCaches;
    }

    public void setNoCaches(List<String> noCaches) {
        this.noCaches = noCaches;
    }

    public List<String> getAnonymous() {
        return anonymous;
    }

    public void setAnonymous(List<String> anonymous) {
        this.anonymous = anonymous;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Boolean getAdvanced() {
        return advanced;
    }

    public void setAdvanced(Boolean advanced) {
        this.advanced = advanced;
    }

}
