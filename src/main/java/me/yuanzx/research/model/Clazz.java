package me.yuanzx.research.model;

/**
 * @author ZhiXiang Yuan
 */
public class Clazz {

    private String magicNumber;
    private int minorVersion;
    private int majorVersion;
    private ConstantPool constantPool;
    private int accessFlag;
    private String className;
    private String superClass;
    private int interfaceCount;
    private String[] interfaces;
    private int fieldCount;
    private MemberInfo[] fields;
    private int methodCount;
    private MemberInfo[] methods;

    public String getMagicNumber() {
        return magicNumber;
    }

    public Clazz setMagicNumber(String magicNumber) {
        this.magicNumber = magicNumber;
        return this;
    }

    public int getMinorVersion() {
        return minorVersion;
    }

    public Clazz setMinorVersion(int minorVersion) {
        this.minorVersion = minorVersion;
        return this;
    }

    public int getMajorVersion() {
        return majorVersion;
    }

    public Clazz setMajorVersion(int majorVersion) {
        this.majorVersion = majorVersion;
        return this;
    }

    public ConstantPool getConstantPool() {
        return constantPool;
    }

    public Clazz setConstantPool(ConstantPool constantPool) {
        this.constantPool = constantPool;
        return this;
    }

    public int getAccessFlag() {
        return accessFlag;
    }

    public Clazz setAccessFlag(int accessFlag) {
        this.accessFlag = accessFlag;
        return this;
    }

    public String getClassName() {
        return className;
    }

    public Clazz setClassName(String className) {
        this.className = className;
        return this;
    }

    public String getSuperClass() {
        return superClass;
    }

    public Clazz setSuperClass(String superClass) {
        this.superClass = superClass;
        return this;
    }

    public int getInterfaceCount() {
        return interfaceCount;
    }

    public Clazz setInterfaceCount(int interfaceCount) {
        this.interfaceCount = interfaceCount;
        return this;
    }

    public String[] getInterfaces() {
        return interfaces;
    }

    public Clazz setInterfaces(String[] interfaces) {
        this.interfaces = interfaces;
        return this;
    }

    public int getFieldCount() {
        return fieldCount;
    }

    public Clazz setFieldCount(int fieldCount) {
        this.fieldCount = fieldCount;
        return this;
    }

    public MemberInfo[] getFields() {
        return fields;
    }

    public Clazz setFields(MemberInfo[] fields) {
        this.fields = fields;
        return this;
    }

    public int getMethodCount() {
        return methodCount;
    }

    public Clazz setMethodCount(int methodCount) {
        this.methodCount = methodCount;
        return this;
    }

    public MemberInfo[] getMethods() {
        return methods;
    }

    public Clazz setMethods(MemberInfo[] methods) {
        this.methods = methods;
        return this;
    }
}
