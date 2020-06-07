package me.yuanzx.research.model.constantinfo;

import java.io.IOException;

import me.yuanzx.research.Context;
import me.yuanzx.research.model.ConstantInfo;
import me.yuanzx.research.util.U1;
import me.yuanzx.research.util.U2;

public class ConstantMethodHandle extends ConstantInfo {

    public short referenceKind;
    public int referenceIndex;

    @Override
    public void decode(Context context) throws IOException {
        referenceKind = U1.read(context);
        referenceIndex = U2.read(context);
    }
}
