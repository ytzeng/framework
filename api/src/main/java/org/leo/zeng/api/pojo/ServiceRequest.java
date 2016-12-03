package org.leo.zeng.api.pojo;

import org.leo.zeng.core.pojo.BaseObject;

@SuppressWarnings("serial")
public class ServiceRequest extends BaseObject {
    /** 消息类型 */
    private String cmdId;
    /** 前置系统编号 */
    private String sysCode;
    /** 前置业务序列号 */
    private String frontSerialNo;
    /** 前置业务时间 YYYY-MM-DD HH:MI:SS */
    private String frontDateTime;

    public String getCmdId() {
        return cmdId;
    }

    public void setCmdId(String cmdId) {
        this.cmdId = cmdId;
    }

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public String getFrontSerialNo() {
        return frontSerialNo;
    }

    public void setFrontSerialNo(String frontSerialNo) {
        this.frontSerialNo = frontSerialNo;
    }

    public String getFrontDateTime() {
        return frontDateTime;
    }

    public void setFrontDateTime(String frontDateTime) {
        this.frontDateTime = frontDateTime;
    }
}
