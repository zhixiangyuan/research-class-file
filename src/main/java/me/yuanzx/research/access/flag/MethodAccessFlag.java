package me.yuanzx.research.access.flag;

import java.util.ArrayList;

/**
 * @author ZhiXiang Yuan
 */
public enum MethodAccessFlag implements AccessFlag {
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
    /** 声明为 synchronized */
    ACC_SYNCHRONIZED(0x0020),
    /** bridge 方法，由编译器生成 */
    ACC_BRIDGE(0x0040),
    /** 方法包含可变长度参数，比如 String... args */
    ACC_VARARGS(0x0080),
    /** 声明为 native */
    ACC_NATIVE(0x0100),
    /** 声明为 abstract */
    ACC_ABSTRACT(0x4000),
    /** 声明为 strictfp，表示使用 IEEE-754 规范的精确浮点数，极少使用 */
    ACC_STRICT(0x0800),
    /** 表示这个方法是由编译器自动生成，而不是用户代码编译产生 */
    ACC_SYNTHETIC(0x1000);

    private int code;

    MethodAccessFlag(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static MethodAccessFlag[] decode(int accessFlag) {
        ArrayList<MethodAccessFlag> list = new ArrayList<>();
        for (MethodAccessFlag value : values()) {
            if ((accessFlag & value.getCode()) == value.getCode()) {
                list.add(value);
            }
        }
        return list.toArray(new MethodAccessFlag[0]);
    }

}
