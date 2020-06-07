package me.yuanzx.research.model.constantinfo;

import java.io.IOException;

import me.yuanzx.research.Context;
import me.yuanzx.research.model.ConstantInfo;
import me.yuanzx.research.util.U2;

public class ConstantString extends ConstantInfo {

    int nameIndex;

    @Override
    public void decode(Context context) throws IOException {
        nameIndex = U2.read(context);
    }
}
