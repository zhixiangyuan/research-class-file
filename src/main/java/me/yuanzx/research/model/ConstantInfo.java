package me.yuanzx.research.model;

import java.io.IOException;

import me.yuanzx.research.Context;
import me.yuanzx.research.model.constantinfo.*;

import me.yuanzx.research.model.constantinfo.ConstantClass;
import me.yuanzx.research.model.constantinfo.ConstantDouble;
import me.yuanzx.research.model.constantinfo.ConstantFloat;
import me.yuanzx.research.model.constantinfo.ConstantInteger;
import me.yuanzx.research.model.constantinfo.ConstantInvokeDynamic;
import me.yuanzx.research.model.constantinfo.ConstantLong;
import me.yuanzx.research.model.constantinfo.ConstantMemberRef;
import me.yuanzx.research.model.constantinfo.ConstantMethodHandle;
import me.yuanzx.research.model.constantinfo.ConstantMethodType;
import me.yuanzx.research.model.constantinfo.ConstantNameAndType;
import me.yuanzx.research.model.constantinfo.ConstantString;
import me.yuanzx.research.model.constantinfo.ConstantUtf8;

/**
 * @author ZhiXiang Yuan
 */
public abstract class ConstantInfo {

    public static final short CONSTANT_Utf8               = 1;
    public static final short CONSTANT_Integer            = 3;
    public static final short CONSTANT_Float              = 4;
    public static final short CONSTANT_Long               = 5;
    public static final short CONSTANT_Double             = 6;
    public static final short CONSTANT_Class              = 7;
    public static final short CONSTANT_String             = 8;
    public static final short CONSTANT_Fieldref           = 9;
    public static final short CONSTANT_Methodref          = 10;
    public static final short CONSTANT_InterfaceMethodref = 11;
    public static final short CONSTANT_NameAndType        = 12;
    public static final short CONSTANT_MethodHandle       = 15;
    public static final short CONSTANT_MethodType         = 16;
    public static final short CONSTANT_InvokeDynamic      = 18;

    private short tag;

    public short getTag() {
        return tag;
    }

    public abstract void decode(Context context) throws IOException;

    public static ConstantInfo getConstantInfo(short tag) {
        switch (tag) {
            case CONSTANT_Class:
                return new ConstantClass();
            case CONSTANT_Fieldref:
            case CONSTANT_Methodref:
            case CONSTANT_InterfaceMethodref:
                return new ConstantMemberRef();
            case CONSTANT_Long:
                return new ConstantLong();
            case CONSTANT_Double:
                return new ConstantDouble();
            case CONSTANT_String:
                return new ConstantString();
            case CONSTANT_Integer:
                return new ConstantInteger();
            case CONSTANT_Float:
                return new ConstantFloat();
            case CONSTANT_NameAndType:
                return new ConstantNameAndType();
            case CONSTANT_Utf8:
                return new ConstantUtf8();
            case CONSTANT_MethodHandle:
                return new ConstantMethodHandle();
            case CONSTANT_MethodType:
                return new ConstantMethodType();
            case CONSTANT_InvokeDynamic:
                return new ConstantInvokeDynamic();
        }
        return null;
    }

}
