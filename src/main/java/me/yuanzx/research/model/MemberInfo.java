package me.yuanzx.research.model;

import java.io.IOException;

import me.yuanzx.research.Context;
import me.yuanzx.research.model.attribute.AttributeInfo;
import me.yuanzx.research.model.constantinfo.ConstantUtf8;
import me.yuanzx.research.util.U2;

public class MemberInfo extends BasicInfo {

    private int accessFlags;
    private int nameIndex;
    private int descriptorIndex;
    private int attributesCount;
    private AttributeInfo[] attributes;

    private String memberName;
    private String descriptor;

    public MemberInfo(ConstantPool cp) {
        super(cp);
    }

    @Override
    public void decode(Context context) throws IOException {
        accessFlags = U2.read(context);
        nameIndex = U2.read(context);
        descriptorIndex = U2.read(context);
        attributesCount = U2.read(context);
        attributes = new AttributeInfo[attributesCount];
        for (int i = 0; i < attributesCount; i++) {
            AttributeInfo attributeInfo = AttributeInfo.getAttribute(constantPool, context);
            attributeInfo.decode(context);
            attributes[i] = attributeInfo;
        }

        memberName = ((ConstantUtf8) constantPool.getCpInfo()[nameIndex]).getValue();
        descriptor = ((ConstantUtf8) constantPool.getCpInfo()[descriptorIndex]).getValue();
    }

    public int getAccessFlags() {
        return accessFlags;
    }

    public MemberInfo setAccessFlags(int accessFlags) {
        this.accessFlags = accessFlags;
        return this;
    }

    public int getNameIndex() {
        return nameIndex;
    }

    public MemberInfo setNameIndex(int nameIndex) {
        this.nameIndex = nameIndex;
        return this;
    }

    public int getDescriptorIndex() {
        return descriptorIndex;
    }

    public MemberInfo setDescriptorIndex(int descriptorIndex) {
        this.descriptorIndex = descriptorIndex;
        return this;
    }

    public int getAttributesCount() {
        return attributesCount;
    }

    public MemberInfo setAttributesCount(int attributesCount) {
        this.attributesCount = attributesCount;
        return this;
    }

    public AttributeInfo[] getAttributes() {
        return attributes;
    }

    public MemberInfo setAttributes(AttributeInfo[] attributes) {
        this.attributes = attributes;
        return this;
    }
}
