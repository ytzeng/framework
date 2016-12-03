package org.leo.zeng.core.enums;

/**
 * 客户端类型
 */
public enum ClientType {
    /** 手机端 */
    MOBILE("mobile"),
    /** 平板端 */
    TABLET("tablet"),
    /** 个人电脑 */
    PC("pc"),
    /** 应用 */
    APP("app"),
    /** 未知 */
    UNKNOWN("unknown");

    private final String value;

    private ClientType(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

}
