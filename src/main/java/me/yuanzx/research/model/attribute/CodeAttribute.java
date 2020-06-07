package me.yuanzx.research.model.attribute;

import java.io.IOException;

import me.yuanzx.research.Context;
import me.yuanzx.research.model.ConstantPool;
import me.yuanzx.research.util.U1;
import me.yuanzx.research.util.U2;
import me.yuanzx.research.util.U4;

public class CodeAttribute extends AttributeInfo {

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
