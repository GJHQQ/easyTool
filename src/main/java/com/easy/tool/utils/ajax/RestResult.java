package com.easy.tool.utils.ajax;

import com.easy.tool.constant.CommonCode;
import com.easy.tool.constant.ResponseCode;
import com.easy.tool.enums.CommonEnum;
import com.easy.tool.enums.ResponseEnum;

/**
 * @author 高俊
 * @create 2021-08-2021/8/27-18:26
 */
public class RestResult<T> {

    private Integer code;

    private String codeName;

    private String msg;

    private T data;

    public RestResult() {
    }

    public RestResult(Integer code, String codeName, String msg, T data) {
        this.code = code;
        this.codeName = codeName;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }


    public static <T> RestResult ok(){
        Integer code = ResponseCode.REQUEST_SUCCESS_CODE;
        String codeName = ResponseEnum.OK.getCodeName();
        return of(code,codeName, null,null);
    }

    /**
     * 其他请求
     * @param inCode 请求码
     * @param <T>
     * @return
     */
    public static <T> RestResult otherCode(Integer inCode){
        // 默认请求码是不存在的
        Integer code = CommonEnum.NO_FOUND_RESPONSE_CODE.getCode();
        String codeName = CommonEnum.NO_FOUND_RESPONSE_CODE.getCodeName();


        ResponseEnum[] values = ResponseEnum.values();
        for (ResponseEnum value : values) {
            // 判断输入的请求码是否存在
            if (value.getCode().equals(inCode)){
                // 重新赋值codeName
                codeName = value.getCodeName();
                // 重新赋值code
                code = value.getCode();
                // 跳出循环节约性能
                break;
            }
        }
        return of(code,codeName, null,null);
    }


    public <T> RestResult msg(String msg){
        return of(this.code, this.codeName, msg,null);
    }


    public <T> RestResult data(T data){
        return of(this.code, this.codeName, this.msg,data);
    }



    private static <T> RestResult of(Integer code, String codeName, String msg, T data){
        return new RestResult(code,codeName,msg,data);
    }

    @Override
    public String toString() {
        return "RestResult{" +
                "code=" + code +
                ", codeName='" + codeName + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
