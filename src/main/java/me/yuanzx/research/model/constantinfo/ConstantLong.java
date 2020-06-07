package me.yuanzx.research.model.constantinfo;

import java.io.IOException;

import me.yuanzx.research.Context;
import me.yuanzx.research.model.ConstantInfo;
import me.yuanzx.research.util.U4;

public class ConstantLong extends ConstantInfo {

    public long highValue;
    public long lowValue;


    @Override
    public void decode(Context context) throws IOException {
        highValue = U4.read(context);
        lowValue = U4.read(context);
    }
}
