package design_pattern;

import java.io.ObjectStreamException;

public class SingletonClass {
    private static volatile SingletonClass instance = null;


    private SingletonClass() {

        // avoid new object creation using reflection
        if (instance != null) {
            throw new RuntimeException("Object creation not allowed through reflection");
        }
    }

    public static SingletonClass getInstance() {

        if (instance == null) {
            synchronized (SingletonClass.class) {
                if (instance == null) {
                    instance = new SingletonClass();
                }
            }
        }

        return instance;
    }

    //avoid cloning
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new RuntimeException("Clone not supported");
    }

    // ensures deserialization returns the same object
    private Object readResolve() throws ObjectStreamException {
        return instance;
    }
}
