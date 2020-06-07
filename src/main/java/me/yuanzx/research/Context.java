package me.yuanzx.research;

import java.io.InputStream;

import me.yuanzx.research.model.Clazz;

/**
 * @author ZhiXiang Yuan
 */
public class Context {

    private final InputStream inputStream;

    private final Clazz clazz;

    public Context(InputStream inputStream) {
        this.inputStream = inputStream;
        this.clazz = new Clazz();
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public Clazz getClazz() {
        return clazz;
    }
}
