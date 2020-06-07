package me.yuanzx.research.util;

import java.io.IOException;

import me.yuanzx.research.Context;

/**
 * @author ZhiXiang Yuan
 */
public class U1 {

    public static short read(Context context) throws IOException {
        return (short) context.getInputStream().read();
    }

}
