package com.example.web.base.share.enm;

/**
 * 类CodeEnum的实现描述：TODO 类实现描述
 *
 * @author hxr 2024/4/7 11:03
 */
public interface CodeEnum<C, T extends Enum<T> & CodeEnum<C, T, V>, V> {
    /**
     * code
     *
     * @return
     */
    public C getCode();

    /**
     * 展示名称
     *
     * @return
     */
    public String getName();

    /**
     * 值,辅助使用
     *
     * @return
     */
    public V getValue();

    /**
     * 前端展示
     *
     * @return
     */
    //    @JsonValue
    public default String display() {
        return getCode() + ":" + getName();
    }

}