package com.easy.tool.enums;


import com.easy.tool.constant.CommonCode;
import com.easy.tool.constant.ResponseCode;

/**
 * @author 高俊
 * @create 2021-08-2021/8/28-11:24
 */
public enum CommonEnum {

    NO_FOUND_RESPONSE_CODE(CommonCode.NO_FONUN_RESPONSE_CODE_ERROR,"您输入的code不存在");

    private Integer code;
    private String codeName;

    CommonEnum(Integer code, String codeName) {
        this.code = code;
        this.codeName = codeName;
    }

    CommonEnum(Integer code) {
        this.code = code;
    }

    CommonEnum() {
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
