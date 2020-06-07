package me.yuanzx.research.model.constantinfo;

import java.io.IOException;

import me.yuanzx.research.Context;
import me.yuanzx.research.model.ConstantInfo;
import me.yuanzx.research.util.U2;

public class ConstantMethodType extends ConstantInfo {

    int descType;

    @Override
    public void decode(Context context) throws IOException {
        descType = U2.read(context);
    }
}
