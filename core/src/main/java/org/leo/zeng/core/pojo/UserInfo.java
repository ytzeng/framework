package org.leo.zeng.core.pojo;

import java.util.Date;
import java.util.List;

/**
 * 用户信息
 */
@SuppressWarnings("serial")
public class UserInfo extends BaseObject {

    /** 用户编号 */
    private String userCode;
    /** 登录名 */
    private String userName;
    /** 昵称 */
    private String nickName;
    /** 昵称 */
    private Date loginTime;
    /** 角色 */
    private List<String> roles;
    /** 权限 */
    private List<String> permissions;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

}
