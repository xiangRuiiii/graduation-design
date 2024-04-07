package com.example.web.base.share.i18n;

import java.util.Locale;

/**
 * 类IMessageSource的实现描述：TODO 类实现描述
 *
 * @author Administrator 2024/4/7 13:51
 */
public interface IMessageSource {

    public String getMessage(String errCode, Locale locale);

    public String getMessage(Class<?> clz, String errCode, Locale locale);

    public String getMessage(String errCode, Object arg, Locale locale);

    public String getMessage(Class<?> clz, String errCode, Object arg, Locale locale);

    public String getMessage(String errCode, Object arg1, Object arg2, Locale locale);

    public String getMessage(Class<?> clz, String errCode, Object arg1, Object arg2, Locale locale);

    public String getMessage(String errCode, Object arg1, Object arg2, Object arg3, Locale locale);

    public String getMessage(Class<?> clz, String errCode, Object arg1, Object arg2, Object arg3, Locale locale);

    public String getMessage(String errCode, Object arg1, Object arg2, Object arg3, Object arg4, Locale locale);

    public String getMessage(String errCode, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5,
                             Locale locale);

    public String getMessage(Class<?> clz, String errCode, Object arg1, Object arg2, Object arg3, Object arg4,
                             Locale locale);

    public String getMessage(String errCode, Object[] args, Locale locale);

    public String getMessage(Class<?> clz, String errCode, Object[] args, Locale locale);
} 