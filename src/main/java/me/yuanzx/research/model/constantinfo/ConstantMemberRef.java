package me.yuanzx.research.model.constantinfo;

import java.io.IOException;

import me.yuanzx.research.Context;
import me.yuanzx.research.model.ConstantInfo;
import me.yuanzx.research.util.U2;

public class ConstantMemberRef extends ConstantInfo {

    public int classIndex;
    public int nameAndTypeIndex;


    @Override
    public void decode(Context context) throws IOException {
        classIndex = U2.read(context);
        nameAndTypeIndex = U2.read(context);
    }
}
