package me.yuanzx.research.model.attribute;

import java.io.IOException;

import me.yuanzx.research.Context;
import me.yuanzx.research.model.BasicInfo;
import me.yuanzx.research.model.ConstantPool;
import me.yuanzx.research.model.constantinfo.ConstantUtf8;
import me.yuanzx.research.util.U1;
import me.yuanzx.research.util.U2;
import me.yuanzx.research.util.U4;

public class AttributeInfo extends BasicInfo {

    private int nameIndex;
    protected int length;
    private short[] info;

    public static final String CODE = "Code";

    public AttributeInfo(ConstantPool constantPool, int nameIndex) {
        super(constantPool);
        this.nameIndex = nameIndex;
    }

    @Override
    public void decode(Context context) throws IOException {
        length = (int) U4.read(context);
        info = new short[length];
        for (int i = 0; i < length; i++) {
            info[i] = U1.read(context);
        }
    }

    public static AttributeInfo getAttribute(ConstantPool constantPool, Context context) throws IOException {
        int nameIndex = U2.read(context);
        String name = ((ConstantUtf8) constantPool.getCpInfo()[nameIndex]).getValue();
        switch (name) {
            case CODE:
                return new CodeAttribute(constantPool, nameIndex);
        }
        return new AttributeInfo(constantPool, nameIndex);

    }
}
