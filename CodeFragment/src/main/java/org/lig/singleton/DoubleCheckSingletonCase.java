package org.lig.singleton;

/**
 * 双检查 线程安全 禁止重排
 *
 */
public class DoubleCheckSingletonCase {

    private static volatile DoubleCheckSingletonCase instance = null;

    private DoubleCheckSingletonCase() {}

    public static DoubleCheckSingletonCase getInstance() {
        if (instance == null){
            synchronized (DoubleCheckSingletonCase.class){
                if (instance == null) {
                    instance = new DoubleCheckSingletonCase();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        DoubleCheckSingletonCase instatce = DoubleCheckSingletonCase.getInstance();
//        instance.
    }
}
