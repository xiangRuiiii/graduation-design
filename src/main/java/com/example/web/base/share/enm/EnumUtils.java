package com.example.web.base.share.enm;

import java.lang.reflect.Method;

/**
 * 类EnumUtils的实现描述：TODO 类实现描述
 *
 * @author hxr 2024/4/7 11:22
 */
public class EnumUtils {
    private static Method M_BY_CODE;
    private static Method M_BY_DISPLAY;
    private static Method M_BY_VALUE;

    static {
        try {
            M_BY_CODE = EnumUtils.class.getMethod("byCode", new Class[] { Object.class, Class.class });
            M_BY_DISPLAY = EnumUtils.class.getMethod("byDisplay", new Class[] { String.class, Class.class });
            M_BY_VALUE = EnumUtils.class.getMethod("byValue", new Class[] { Object.class, Class.class });
        } catch (Exception e) {
        }
    }

    /**
     * code 获取
     *
     * @param val
     * @param enumClz
     * @return
     */
    public static <C, T extends Enum<T> & CodeEnum<C, T, V>, V> T byValue(V val, Class<T> enumClz) {
        T[] enums = enumClz.getEnumConstants();
        if (enums == null || enums.length == 0 || val == null)
            return null;
        for (T enm : enums) {
            if (val.equals(enm.getValue()))
                return enm;
        }
        return null;
    }

    /**
     * code 获取
     *
     * @param code
     * @param enumClz
     * @return
     */
    public static <C, T extends Enum<T> & CodeEnum<C, T, V>, V> T byCode(C code, Class<T> enumClz) {
        T[] enums = enumClz.getEnumConstants();
        if (enums == null || enums.length == 0)
            return null;
        for (T enm : enums) {
            if (enm.getCode().equals(code))
                return enm;
        }
        return null;
    }

    /**
     * 名称
     *
     * @param <T>
     * @param name
     * @param enumClz
     * @return
     */
    public static <T extends Enum<T>> T byName(String name, Class<T> enumClz) {
        T[] enums = enumClz.getEnumConstants();
        if (enums == null || enums.length == 0)
            return null;
        for (T enm : enums) {
            if (name.equals(enm.name()))
                return enm;
        }
        return null;
    }
} 