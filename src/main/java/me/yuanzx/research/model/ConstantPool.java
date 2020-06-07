package me.yuanzx.research.model;

import java.io.IOException;

import me.yuanzx.research.Context;
import me.yuanzx.research.util.U1;

/**
 * @author ZhiXiang Yuan
 */
public class ConstantPool {

    private int constantPoolCount;
    private ConstantInfo[] cpInfo;

    public void decode(Context context) throws IOException {
        for (int i = 1; i < constantPoolCount; i++) {
            short tag = U1.read(context);
            ConstantInfo constantInfo = ConstantInfo.getConstantInfo(tag);
            constantInfo.decode(context);
            cpInfo[i] = constantInfo;
            if (tag == ConstantInfo.CONSTANT_Double || tag == ConstantInfo.CONSTANT_Long) {
                i++;
            }
        }
    }

    public ConstantPool(int count) {
        constantPoolCount = count;
        cpInfo = new ConstantInfo[constantPoolCount];
    }

    public int getConstantPoolCount() {
        return constantPoolCount;
    }

    public ConstantPool setConstantPoolCount(int constantPoolCount) {
        this.constantPoolCount = constantPoolCount;
        return this;
    }

    public ConstantInfo[] getCpInfo() {
        return cpInfo;
    }

    public ConstantPool setCpInfo(ConstantInfo[] cpInfo) {
        this.cpInfo = cpInfo;
        return this;
    }
}
