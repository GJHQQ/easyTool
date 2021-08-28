package com.easy.tool.enums;


import com.easy.tool.constant.ResponseCode;

/**
 * @author 高俊
 * @create 2021-08-2021/8/28-11:24
 */
public enum ResponseEnum {

    OK(ResponseCode.REQUEST_SUCCESS_CODE,"请求成功"),
    BAD_REQUEST(ResponseCode.REQUEST_BAD_REQUEST_CODE,"请求错误"),
    SERVICE_ERROR(ResponseCode.REQUEST_SERVICE_ERROR_CODE,"服务器内部错误"),
    NO_AUTH(ResponseCode.REQUEST_NO_AUTH_CODE,"未授权"),
    TIME_OUT(ResponseCode.REQUEST_TIME_OUT_CODE,"服请求超时"),
    SERVICE_REFUSE(ResponseCode.REQUEST_SERVICE_REFUSE_CODE,"服务器拒绝访问（无权限）");

    private Integer code;
    private String codeName;

    ResponseEnum(Integer code, String codeName) {
        this.code = code;
        this.codeName = codeName;
    }

    ResponseEnum(Integer code) {
        this.code = code;
    }

    ResponseEnum() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    @Override
    public String toString() {
        return "ResponseEnum{" +
                "code=" + code +
                ", codeName='" + codeName + '\'' +
                '}';
    }
}
