package com.example.web.base.share.constant;

/**
 * 类CommonErrorCode的实现描述：TODO 类实现描述
 *
 * @author Administrator 2024/4/7 11:51
 */
public enum CommonErrorCode implements ErrorCode{

    // 通用错误
    CMN_MY_ERROR("110000", "{}");


    private String code;
    private String pattern;

    private CommonErrorCode(String code, String pattern){
        this.code = code;
        this.pattern = pattern;
    }

    public String getCode(){
        return code;
    }

    @Override
    public String getErrorMsg(Object... params) {
        return null;
    }

}
