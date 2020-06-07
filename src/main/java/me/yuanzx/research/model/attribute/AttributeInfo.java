package me.yuanzx.research.model.attribute;

import java.io.IOException;

import me.yuanzx.research.Context;
import me.yuanzx.research.model.BasicInfo;
import me.yuanzx.research.model.ConstantPool;
import me.yuanzx.research.model.constantinfo.ConstantUtf8;
import me.yuanzx.research.util.U1;
import me.yuanzx.research.util.U2;
import me.yuanzx.research.util.U4;

/**
 * 通用结构:
 *
 * attribute_info {
 *     u2 attribute_name_index;
 *     u4 attribute_length;
 *     u1 info[attribute_length];
 * }
 */
public class AttributeInfo extends BasicInfo {

    private int nameIndex;
    protected int length;
    /** 这个字段貌似不是通用的 */
    private short[] info;



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
            case CodeAttribute.CODE:
                return new CodeAttribute(constantPool, nameIndex);
        }
        return new AttributeInfo(constantPool, nameIndex);

    }
}
