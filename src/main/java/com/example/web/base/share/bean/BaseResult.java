package com.example.web.base.share.bean;

import org.slf4j.helpers.MessageFormatter;

import com.example.web.base.share.constant.ErrorCode;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 类BaseResult的实现描述：TODO 类实现描述
 *
 * @author hxr 2024/4/7 11:42
 */
public class BaseResult<T> implements Serializable {
    private static final long      serialVersionUID = 5758020086424746744L;

    public static final String     SUCCESS_CODE     = "0";

    @SuppressWarnings({ "rawtypes" })
    public static final BaseResult NULL_SUCCESS     = ok(null);

    private String                 code;
    private String                 message;
    private T                      result;

    public BaseResult(String code, String message, T data) {
        super();
        this.code = code;
        this.message = message;
        this.result = data;
    }

    public BaseResult() {
        super();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 格式化设置消息。从slfj借过来的格式化工具，吊炸天。 例如：
     *
     * <pre>
     * result.setMessage(&quot;Hi {}.&quot;, &quot;there&quot;)
     * </pre>
     *
     * @param format 消息格式
     * @param arguments 参数
     */
    public void setMessage(String format, Object... arguments) {
        if (format == null || arguments == null) {
            this.message = format;
        } else {
            this.message = MessageFormatter.arrayFormat(format, arguments).getMessage();
        }
    }

    public void setCodeSuccess() {
        this.code = SUCCESS_CODE;
    }

    public boolean success() {
        return SUCCESS_CODE.equals(code);
    }

    public boolean failed() {
        return !success();
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public void setSuccess(T result) {
        setCodeSuccess();
        this.result = result;
    }

    public static <T> BaseResult<T> ok(T data) {
        BaseResult<T> br = new BaseResult<T>(SUCCESS_CODE, null, data);
        return br;
    }

    @SuppressWarnings("unchecked")
    public static <T> BaseResult<T> ok() {
        return (BaseResult<T>) NULL_SUCCESS;
    }

    public static BaseResult<Map<String, Object>> okMap(Object data) {
        if (data == null)
            return ok();
        Map<String, Object> maps = new HashMap<>(1);
        maps.put("value", data);
        return ok(maps);
    }

    public static <T> BaseResult<T> fail(ErrorCode code, Object... params) {
        return new BaseResult<T>(code.getCode(), code.getErrorMsg(params), null);
    }

    @Override
    public String toString() {
        return "BaseResult [code=" + code + ", message=" + message + ", result=" + result + "]";
    }
} 