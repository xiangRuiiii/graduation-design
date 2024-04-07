package com.example.web.base.share.enm;

/**
 * 类YesOrNo的实现描述：TODO 类实现描述
 *
 * @author hxr 2024/4/7 11:14
 */
public enum YesOrNo implements CodeEnum<String, YesOrNo, String>{
    YES("Y", "是", "Y")
    ,
    NO("N", "否", "N");
    String code;
    String name;
    String value;

    private YesOrNo(String code, String name, String value) {
        this.code = code;
        this.name = name;
        this.value = value;
    }

    @Override
    public String getCode() {
        return code;
    }

    public YesOrNo inverse() {
        return this == YES ? NO : YES;
    }

    public static YesOrNo of(String code) {
        return EnumUtils.byCode(code, YesOrNo.class);
    }

    public static YesOrNo of(boolean b) {
        return b ? YesOrNo.YES : YesOrNo.NO;
    }

    public static YesOrNo ofName(String name) {
        for (YesOrNo value : YesOrNo.values()) {
            if (value.getName().equals(name)) {
                return value;
            }
        }
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getValue() {
        return value;
    }
} 