package com.easy.tool.constant;

/**
 * @author 高俊
 * @create 2021-08-2021/8/28-10:53
 */
public class ResponseCode {

    // 请求成功
    public static final Integer REQUEST_SUCCESS_CODE = 200;

    // 请求错误
    public static final Integer REQUEST_BAD_REQUEST_CODE = 400;

    // 未授权
    public static final Integer REQUEST_NO_AUTH_CODE = 401;

    // 服务器拒绝请求（没有权限）
    public static final Integer REQUEST_SERVICE_REFUSE_CODE = 403;

    // 服请求超时
    public static final Integer REQUEST_TIME_OUT_CODE = 408;

    // 服务器内部错误
    public static final Integer REQUEST_SERVICE_ERROR_CODE = 500;

}
