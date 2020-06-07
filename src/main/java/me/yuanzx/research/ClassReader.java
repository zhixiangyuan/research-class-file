package me.yuanzx.research;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import me.yuanzx.research.log.Log;
import me.yuanzx.research.model.Clazz;
import me.yuanzx.research.model.ConstantPool;
import me.yuanzx.research.model.InstructionTable;
import me.yuanzx.research.model.MemberInfo;
import me.yuanzx.research.model.attribute.CodeAttribute;
import me.yuanzx.research.model.constantinfo.ConstantUtf8;
import me.yuanzx.research.util.HexUtils;
import me.yuanzx.research.util.U2;
import me.yuanzx.research.model.constantinfo.ConstantClass;


/**
 * @author ZhiXiang Yuan
 */
public class ClassReader {

    public static Clazz read(String filePath) {
        File file = new File(filePath);
        try (FileInputStream fileInputStream = new FileInputStream(file);) {
            Context context = new Context(fileInputStream);
            decodeClassFile(context);
            return context.getClazz();
        } catch (IOException e) {
            Log.info("解析 class 文件失败");
            return null;
        }
    }

    private static void decodeClassFile(Context context) throws IOException {
        // 解析 Magic Number
        byte[] magicNumberByteArr = new byte[4];
        context.getInputStream().read(magicNumberByteArr);
        // Java 魔数是一个十六进制为 0xCAFEBABY 的数字
        String magicNumber = HexUtils.toHexString(magicNumberByteArr);
        if (Constant.CAFEBABE.equalsIgnoreCase(magicNumber)) {
            context.getClazz().setMagicNumber(Constant.CAFEBABE);
        } else {
            throw new IllegalArgumentException("This file is not java class.");
        }

        // 解析 MinorVersion 和 MajorVersion
        context.getClazz()
            .setMinorVersion(U2.read(context))
            .setMajorVersion(U2.read(context));

        // 解析 Constant Pool
        decodeConstantPool(context);

        // 解析 class info
        decodeClassInfo(context);

        // 解析 interface info
        decodeInterfaceInfo(context);

        // 解析 field info
        decodeFieldInfo(context);

        // 解析 method info
        decodeMethods(context);
    }

    private static void decodeMethods(Context context) throws IOException {
        Clazz clazz = context.getClazz();
        ConstantPool constantPool = clazz.getConstantPool();
        // 解析 methodCount
        int methodCount = U2.read(context);
        clazz.setMethodCount(methodCount);

        MemberInfo[] memberInfos = new MemberInfo[methodCount];
        clazz.setMethods(memberInfos);
        // 解析 method info
        for (int i = 0; i < methodCount; i++) {
            MemberInfo methodInfo = new MemberInfo(constantPool);
            memberInfos[i] = methodInfo;
            methodInfo.decode(context);
            for (int j = 0; j < methodInfo.getAttributesCount(); j++) {
                if (methodInfo.getAttributes()[j] instanceof CodeAttribute) {
                    CodeAttribute codeAttribute = (CodeAttribute) methodInfo.getAttributes()[j];

                    // 解析指令集
                    String[] instructions = new String[codeAttribute.getCodeLength()];
                    codeAttribute.setInstructions(instructions);
                    for (int k = 0; k < codeAttribute.getCodeLength(); k++) {
                        short code = codeAttribute.getCode()[k];
                        instructions[k] = InstructionTable.getInstruction(code);
                    }
                }
            }
        }

    }

    private static void decodeFieldInfo(Context context) throws IOException {
        Clazz clazz = context.getClazz();
        ConstantPool constantPool = clazz.getConstantPool();
        // 解析 fieldCount
        int fieldCount = U2.read(context);
        clazz.setFieldCount(fieldCount);

        MemberInfo[] memberInfos = new MemberInfo[fieldCount];
        clazz.setFields(memberInfos);
        // 解析 field info
        for (int i = 0; i < fieldCount; i++) {
            MemberInfo methodInfo = new MemberInfo(constantPool);
            methodInfo.decode(context);
            memberInfos[i] = methodInfo;
        }
    }

    private static void decodeClassInfo(Context context) throws IOException {
        Clazz clazz = context.getClazz();
        clazz.setAccessFlag(U2.read(context));

        ConstantPool constantPool = clazz.getConstantPool();
        // 解析 this class name
        int thisClassIndex = U2.read(context);
        ConstantClass thisConstantClass = (ConstantClass) constantPool.getCpInfo()[thisClassIndex];
        ConstantUtf8 thisClassName = (ConstantUtf8) constantPool.getCpInfo()[thisConstantClass.getNameIndex()];
        clazz.setClassName(thisClassName.getValue());

        // 解析 super class name
        int superClassIndex = U2.read(context);
        ConstantClass superConstantClass = (ConstantClass) constantPool.getCpInfo()[superClassIndex];
        ConstantUtf8 superClassName = (ConstantUtf8) constantPool.getCpInfo()[superConstantClass.getNameIndex()];
        clazz.setSuperClass(superClassName.getValue());
    }

    private static void decodeInterfaceInfo(Context context) throws IOException {
        Clazz clazz = context.getClazz();
        // 解析 interfaceCount
        int interfaceCount = U2.read(context);
        clazz.setInterfaceCount(interfaceCount);
        ConstantPool constantPool = clazz.getConstantPool();
        String[] interfaces = new String[interfaceCount];
        clazz.setInterfaces(interfaces);
        // 解析 interfaceName
        for (int i = 0; i < interfaceCount; i++) {
            int interfaceIndex = U2.read(context);
            ConstantClass interfaceClazz = (ConstantClass) constantPool.getCpInfo()[interfaceIndex];
            ConstantUtf8 interfaceName = (ConstantUtf8) constantPool.getCpInfo()[interfaceClazz.getNameIndex()];
            interfaces[i] = interfaceName.getValue();
        }
    }

    private static void decodeConstantPool(Context context) throws IOException {
        // 解析 Constant Pool Count
        int constantPoolCount = U2.read(context);
        ConstantPool constantPool = new ConstantPool(constantPoolCount);
        context.getClazz().setConstantPool(constantPool);

        constantPool.decode(context);
    }
}
