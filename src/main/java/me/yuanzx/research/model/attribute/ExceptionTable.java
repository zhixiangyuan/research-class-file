package me.yuanzx.research.model.attribute;

import java.io.IOException;

import me.yuanzx.research.Context;
import me.yuanzx.research.util.U2;

/**
 * exception_table {
 *
 * }
 */
public class ExceptionTable {

    public int startPc;
    public int endPc;
    public int handlerPc;
    public int catchType;

    public void decode(Context context) throws IOException {
        startPc = U2.read(context);
        endPc = U2.read(context);
        handlerPc = U2.read(context);
        catchType = U2.read(context);
    }
}
