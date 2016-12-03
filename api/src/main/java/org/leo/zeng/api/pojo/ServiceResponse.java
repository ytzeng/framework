package org.leo.zeng.api.pojo;

import org.leo.zeng.core.pojo.BaseObject;

@SuppressWarnings("serial")
public class ServiceResponse extends BaseObject {
    /** 消息类型 */
    private String cmdId;
    /** 应答系统编号 */
    private String sysCode;
    /** 应答序列号 */
    private String serialNo;
    /** 应答返回码 */
    private String respCode;
    /** 应答描述 */
    private String respDesc;
    /** 应答时间 YYYY-MM-DD HH:MI:SS */
    private String respDateTime;

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

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespDesc() {
        return respDesc;
    }

    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc;
    }

    public String getRespDateTime() {
        return respDateTime;
    }

    public void setRespDateTime(String respDateTime) {
        this.respDateTime = respDateTime;
    }
}
