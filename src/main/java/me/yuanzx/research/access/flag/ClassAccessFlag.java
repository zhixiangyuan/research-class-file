package me.yuanzx.research.access.flag;

import java.util.ArrayList;

/**
 * @author ZhiXiang Yuan
 */
public enum ClassAccessFlag implements AccessFlag {
    /** 标识是否是 public */
    ACC_PUBLIC(0x00000001),
    /** 标识是否是 final */
    ACC_FINAL(0x00000010),
    /** 已经不用了 */
    ACC_SUPER(0x00000020),
    /** 标识是类还是接口 */
    ACC_INTERFACE(0x00000200),
    /** 标识是否是 abstract */
    ACC_ABSTRACT(0x00000400),
    /** 编译器自动生成，不是用户原代码编译生成 */
    ACC_SYNTHETIC(0x00001000),
    /** 标识是否是注解类 */
    ACC_ANNOTATION(0x00002000),
    /** 标识是否是枚举类型 */
    ACC_ENUM(0x00004000);

    public int code;

    ClassAccessFlag(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ClassAccessFlag[] decode(int accessFlag) {
        ArrayList<ClassAccessFlag> list = new ArrayList<>();
        for (ClassAccessFlag value : values()) {
            if ((accessFlag & value.getCode()) == value.getCode()) {
                list.add(value);
            }
        }
        return list.toArray(new ClassAccessFlag[0]);
    }
}
