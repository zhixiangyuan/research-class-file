package me.yuanzx.research;

import me.yuanzx.research.model.Clazz;

/**
 * @author ZhiXiang Yuan
 */
public class Main {

    public static void main(String[] args) {
        Clazz clazz = ClassReader.read(
            "/Users/yuanzhixiang/workspace/project/tmp/research-class-file/target/classes/com/alibaba/research/ClassReader.class");
        System.out.println(clazz);
    }
}
