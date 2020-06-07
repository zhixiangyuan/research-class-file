package me.yuanzx.research.model.attribute;

import java.io.IOException;

import me.yuanzx.research.Context;
import me.yuanzx.research.model.ConstantPool;
import me.yuanzx.research.util.U1;
import me.yuanzx.research.util.U2;
import me.yuanzx.research.util.U4;

/**
 * Code_attribute{
 *     // 该值必须是常量池的有效索引，常量池索引必须是 CONSTANT_Utf8_info，值是 "Code"
 *     u2 attribute_name_index;
 *
 *     // 当前属性长度，不包括初始的 6 个字节（attribute_name_index 和 attribute_length 的长度）
 *     u4 attribute_length;
 *
 *     // 当前方法的操作数栈在方法执行的时间点的最大深度
 *     u2 max_stack;
 *
 *     // 当前方法引用的局部变量表中的局部变量个数，其中也包括调用此方法时用于传递参数的局部变量
 *     // long 和 double 类型的局部变量的最大索引是 max_local-2，其它类型的局部变量变量的最大
 *     // 索引是 max_local-1
 *     u2 max_locals;
 *
 *     // 当前方法 code[] 数组的字节数，code_length 的值必须大于 0，即 code[] 数组不能为空
 *     u4 code_length;
 *
 *     // code[] 数组给出了实现当前方法的 Java 虚拟机代码的实际字节内容
 *     u1 code[code_length];
 *
 *     // exception_table 表的成员个数
 *     u2 exception_table_length;
 *
 *     // exception_table[] 数组的每个成员表示 code[] 数组中的一个异常处理器
 *     // exception_table[] 的一场处理器顺序是有意义的，不能随意更改
 *     exception_table exception_table[exception_table_length];
 *
 *     // attributes_count 指明 attributes[] 数组的成员个数
 *     u2 attributes_count;
 *
 *     // Code 属性可以关联任意多个属性
 *     attribute_info attributes[attributes_count]
 * }
 */
public class CodeAttribute extends AttributeInfo {

    public static final String CODE = "Code";

    private int maxStack;
    private int maxLocals;
    private int codeLength;
    private short[] code;
    private int exceptionTableLength;
    private ExceptionTable[] exceptionTable;
    private int attributesCount;
    private AttributeInfo[] attributes;
    private String[] instructions;

    public CodeAttribute(ConstantPool constantPool, int nameIndex) {
        super(constantPool, nameIndex);
    }

    @Override
    public void decode(Context context) throws IOException {
        length = (int) U4.read(context);
        maxStack = U2.read(context);
        maxLocals = U2.read(context);
        codeLength = (int) U4.read(context);
        code = new short[codeLength];
        for (int i = 0; i < codeLength; i++) {
            code[i] = U1.read(context);
        }
        exceptionTableLength = U2.read(context);
        exceptionTable = new ExceptionTable[exceptionTableLength];
        for (int i = 0; i < exceptionTableLength; i++) {
            ExceptionTable exceptionTable = new ExceptionTable();
            exceptionTable.decode(context);
            this.exceptionTable[i] = exceptionTable;
        }
        attributesCount = U2.read(context);
        attributes = new AttributeInfo[attributesCount];
        for (int i = 0; i < attributesCount; i++) {
            AttributeInfo attr = AttributeInfo.getAttribute(constantPool, context);
            attr.decode(context);
            attributes[i] = attr;
        }

    }

    public int getMaxStack() {
        return maxStack;
    }

    public int getMaxLocals() {
        return maxLocals;
    }

    public int getCodeLength() {
        return codeLength;
    }

    public short[] getCode() {
        return code;
    }

    public int getExceptionTableLength() {
        return exceptionTableLength;
    }

    public ExceptionTable[] getExceptionTable() {
        return exceptionTable;
    }

    public int getAttributesCount() {
        return attributesCount;
    }

    public AttributeInfo[] getAttributes() {
        return attributes;
    }

    public String[] getInstructions() {
        return instructions;
    }

    public CodeAttribute setInstructions(String[] instructions) {
        this.instructions = instructions;
        return this;
    }
}
