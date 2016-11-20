package org.leo.zeng.core.consts;

public class MessageCode {
    /** 0000：成功 */
    public static final String SUCCESS = "0000";
    /** 空值 */
    public static final String BLANK = "blank";
    /** 系统未知异常 */
    public static final String DEFAULT_ERROR = "系统未知异常";

    // 9000 -> 9999  通用系统异常
    /** 9997：用户未登录或者登录已过期 */
    public static final String S9997 = "9997";
    /** 9998：{0}处理失败 */
    public static final String S9998 = "9998";
    /** 9999：系统异常 */
    public static final String S9999 = "9999";

    // 0001 -> 2000 格式校验
    /** 0001：{0}不能为空 */
    public static final String V0001 = "0001";
    /** 0002：{0}的格式不正确，请输入{1}格式的数据 */
    public static final String V0002 = "0002";
    /** 0003：{0}的长度不能超过{1}位 */
    public static final String V0003 = "0003";
    /** 0004：{0}的长度不能少于{1}位 */
    public static final String V0004 = "0004";
    /** 0005：{0}的长度不在{1}位与{2}位之间 */
    public static final String V0005 = "0005";
    /** 0006：{0}的数值不能超过{1} */
    public static final String V0006 = "0006";
    /** 0007：{0}的数值不能小于{1} */
    public static final String V0007 = "0007";
    /** 0008：{0}的数值不在{1}与{2}之间 */
    public static final String V0008 = "0008";
    /** 0009：{0}的字节长度不能超过{1}位 */
    public static final String V0009 = "0009";
    /** 0010：{0}的字节长度不能少于{1}位 */
    public static final String V0010 = "0010";
    /** 0011：{0}的字节长度不在{1}位与{2}位之间 */
    public static final String V0011 = "0011";
    /** 0012：{0}的数值不能超过{1}位，其中小数位为不能超过{2}位 */
    public static final String V0012 = "0012";
    /** 0013：{0}的不是正确的邮箱 */
    public static final String V0013 = "0013";
    /** 0014：{0}的不是正确的身份证号 */
    public static final String V0014 = "0014";
    /** 0015：{0}的不是正确的手机号 */
    public static final String V0015 = "0015";
    /** 0016：{0}的不是正确的邮编 */
    public static final String V0016 = "0016";
    /** 0017：{0}的不是正确的URL路径 */
    public static final String V0017 = "0017";
    /** 0018：{0}的格式不正确，请输入汉字 */
    public static final String V0018 = "0018";
    /** 0019：{0}的格式不正确，密码必须长度在6到16位之间并且含有英文大小写和数字 */
    public static final String V0019 = "0019";
    /** 0020：{0}的不是正确的IP地址 */
    public static final String V0020 = "0020";

    // 2001 -> 5000 通用警告消息
    /** 2001：本操作有未知风险 */
    public static final String W2001 = "2001";

    // 5001 -> 8000 通用错误消息
    /** 5001：用户名不存在 */
    public static final String E5001 = "5001";
    /** 5002：密码不正确 */
    public static final String E5002 = "5002";
    /** 5003：用户名或密码不正确 */
    public static final String E5003 = "5003";
    /** 5004：{0}不存在 */
    public static final String E5004 = "5004";
    /** 5005：{0}不正确 */
    public static final String E5005 = "5005";

    // 8001 -> 9000 通用提示消息
    /** 8001：{0}操作成功 */
    public static final String M8001 = "8001";
}
