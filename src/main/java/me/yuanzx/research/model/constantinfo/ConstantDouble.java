package me.yuanzx.research.model.constantinfo;

import java.io.IOException;

import me.yuanzx.research.Context;
import me.yuanzx.research.model.ConstantInfo;
import me.yuanzx.research.util.U4;

public class ConstantDouble extends ConstantInfo {

    private long highValue;
    private long lowValue;

    @Override
    public void decode(Context context) throws IOException {
        highValue = U4.read(context);
        lowValue = U4.read(context);
    }
}
