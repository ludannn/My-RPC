package top.guoziyang.rpc.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 单例工厂
 * (确保每个类只有一个实例对象 并且在多线程环境下也能保证线程安全)
 * @author ziyang
 */
public class SingletonFactory {

    private static Map<Class, Object> objectMap = new HashMap<>();//用来存储不同的实例对象

    private SingletonFactory() {}

    public static <T> T getInstance(Class<T> clazz) {
        Object instance = objectMap.get(clazz);
        synchronized (clazz) {
            if(instance == null) {//如果为null 则反射创建一个新的实例
                try {
                    instance = clazz.newInstance();
                    objectMap.put(clazz, instance);
                } catch (IllegalAccessException | InstantiationException e) {
                    throw new RuntimeException(e.getMessage(), e);
                }
            }
        }
        return clazz.cast(instance);
    }

}
