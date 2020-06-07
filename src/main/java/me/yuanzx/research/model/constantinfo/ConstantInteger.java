package me.yuanzx.research.model.constantinfo;


import java.io.IOException;

import me.yuanzx.research.Context;
import me.yuanzx.research.model.ConstantInfo;
import me.yuanzx.research.util.U4;

public class ConstantInteger extends ConstantInfo {

    private long value;

    @Override
    public void decode(Context context) throws IOException {
        value = U4.read(context);
    }


}
