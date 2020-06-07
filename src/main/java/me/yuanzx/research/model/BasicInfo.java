package me.yuanzx.research.model;

import java.io.IOException;

import me.yuanzx.research.Context;

public abstract class BasicInfo {

    protected ConstantPool constantPool;

    public BasicInfo(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    public abstract void decode(Context context) throws IOException;
}
