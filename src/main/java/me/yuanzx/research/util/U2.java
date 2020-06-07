package me.yuanzx.research.util;

import java.io.IOException;

import me.yuanzx.research.Context;

/**
 * @author ZhiXiang Yuan
 */
public class U2 {

    public static int read(Context context) throws IOException {
        byte[] bytes = new byte[2];
        context.getInputStream().read(bytes);
        int num = 0;
        for (int i = 0; i < bytes.length; i++) {
            num <<= 8;
            num |= (bytes[i] & 0xff);
        }
        return num;
    }

}
