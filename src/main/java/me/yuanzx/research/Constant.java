package me.yuanzx.research;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhiXiang Yuan
 */
public abstract class Constant {

    public static final String CAFEBABE = "CAFEBABE";

    /** 主版本号和 Java 版本的对应关系 */
    public static final Map<Integer, String> MAJOR_VERSION_TO_JAVA_VERSION_MAP = new HashMap<Integer, String>() {{
        put(48, "Java 4");
        put(49, "Java 5");
        put(50, "Java 6");
        put(51, "Java 7");
        put(52, "Java 8");
        put(53, "Java 9");
    }};

}
