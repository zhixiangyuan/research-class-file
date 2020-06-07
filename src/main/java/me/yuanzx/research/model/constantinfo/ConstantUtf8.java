package me.yuanzx.research.model.constantinfo;

import java.io.IOException;

import me.yuanzx.research.Context;
import me.yuanzx.research.model.ConstantInfo;
import me.yuanzx.research.util.U2;

public class ConstantUtf8 extends ConstantInfo {

    private String value;

    public String getValue() {
        return value;
    }

    @Override
    public void decode(Context context) throws IOException {
        int length = U2.read(context);
        byte[] bytes = new byte[length];
        context.getInputStream().read(bytes);
        value = new String(bytes);
    }
}
