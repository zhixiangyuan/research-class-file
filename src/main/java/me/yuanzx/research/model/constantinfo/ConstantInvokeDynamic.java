package me.yuanzx.research.model.constantinfo;

import java.io.IOException;

import me.yuanzx.research.Context;
import me.yuanzx.research.model.ConstantInfo;
import me.yuanzx.research.util.U2;

public class ConstantInvokeDynamic extends ConstantInfo {

    private int bootstrapMethodAttrIndex;
    private int nameAndTypeIndex;

    @Override
    public void decode(Context context) throws IOException {
        bootstrapMethodAttrIndex = U2.read(context);
        nameAndTypeIndex = U2.read(context);
    }
}
