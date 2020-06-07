package me.yuanzx.research.log;

/**
 * @author ZhiXiang Yuan
 */
public class Log {

    public static void info(String msg, Object... args) {
        int i = 0;
        int j;
        StringBuilder stringBuilder = new StringBuilder(msg.length() + 50);
        int L;
        for (L = 0; L < args.length; L++) {
            j = msg.indexOf("{}", i);
            if (j != -1) {
                stringBuilder.append(msg, i, j);
                stringBuilder.append(args[L]);
                i = j + 2;
            } else {
                break;
            }
        }
        stringBuilder.append(msg, i, msg.length());
        System.out.println(stringBuilder.toString());
    }

}
