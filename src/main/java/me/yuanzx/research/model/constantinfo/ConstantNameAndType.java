package me.yuanzx.research.model.constantinfo;

import java.io.IOException;

import me.yuanzx.research.Context;
import me.yuanzx.research.model.ConstantInfo;
import me.yuanzx.research.util.U2;

public class ConstantNameAndType extends ConstantInfo {

    public int nameIndex;
    public int descIndex;

    @Override
    public void decode(Context context) throws IOException {
        nameIndex = U2.read(context);
        descIndex = U2.read(context);
    }
}
