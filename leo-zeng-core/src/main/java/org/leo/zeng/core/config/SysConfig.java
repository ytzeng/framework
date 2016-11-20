package org.leo.zeng.core.config;

public class SysConfig {

    /** 系统编号 */
    private String sysCode;
    /** APP客户端前缀 */
    private String appPrefix;

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public String getAppPrefix() {
        return appPrefix;
    }

    public void setAppPrefix(String appPrefix) {
        this.appPrefix = appPrefix;
    }
}
