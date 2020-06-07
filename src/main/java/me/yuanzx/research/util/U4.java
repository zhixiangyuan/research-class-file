package me.yuanzx.research.util;

import java.io.IOException;

import me.yuanzx.research.Context;

/**
 * @author ZhiXiang Yuan
 */
public class U4 {

    public static long read(Context context) throws IOException {
        byte[] bytes = new byte[4];
        context.getInputStream().read(bytes);
        long num = 0;
        for (int i = 0; i < bytes.length; i++) {
            num <<= 8;
            num |= (bytes[i] & 0xff);
        }
        return num;
    }

}
