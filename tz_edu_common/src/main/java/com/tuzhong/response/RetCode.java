package com.tuzhong.response;

/**
 * @ProjectName: tz_edu_parent
 * @Package: com.tuzhong.response
 * @Author: WangYongShuai
 * @Description: 定义操作状态码
 * @Date: 2020/11/1 15:14
 * @Version: 1.0
 */
public interface RetCode {
    /**
     * 成功
     */
    int OK = 20000;
    /**
     * 失败
     */
    int ERROR = 20001;
    /**
     * 用户名或密码错误
     */
    int LOGIN_ERROR = 20002;
    /**
     * 权限不足
     */
    int ACCESS_ERROR = 20003;
    /**
     * 远程调用失败
     */
    int REMOTE_ERROR = 20004;
    /**
     * 重复操作
     */
    int REPEAT_ERROR = 20005;
}