package me.yuanzx.research.access.flag;

import java.util.ArrayList;

/**
 * @author ZhiXiang Yuan
 */
public enum FieldAccessFlag implements AccessFlag {
    /** 声明为 public */
    ACC_PUBLIC(0x0001),
    /** 声明为 private */
    ACC_PRIVATE(0x0002),
    /** 声明为 protected */
    ACC_PROTECTED(0x0004),
    /** 声明为 static */
    ACC_STATIC(0x0008),
    /** 声明为 final */
    ACC_FINAL(0x0010),
    /** 声明为 volatile，解决内存可见性的问题 */
    ACC_VOLATILE(0x0040),
    /** 声明为 transient，被 transient 修饰的字段默认不会被序列化 */
    ACC_TRANSIENT(0x0080),
    /** 表示这个字段是由编译器自动生成，而不是用户代码编译产生 */
    ACC_SYNTHETIC(0x1000),
    /** 表示这是一个枚举类型的变量 */
    ACC_ENUM(0x4000),
    ;

    private int code;

    FieldAccessFlag(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static FieldAccessFlag[] decode(int accessFlag) {
        ArrayList<FieldAccessFlag> list = new ArrayList<>();
        for (FieldAccessFlag value : values()) {
            if ((accessFlag & value.getCode()) == value.getCode()) {
                list.add(value);
            }
        }
        return list.toArray(new FieldAccessFlag[0]);
    }
}
