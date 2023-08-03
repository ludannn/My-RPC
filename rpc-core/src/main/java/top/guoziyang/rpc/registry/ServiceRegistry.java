package top.guoziyang.rpc.registry;

/**
 * 2.服务注册表的容器
 */
public interface ServiceRegistry {
    <T> void register(T service);               //2.register注册服务信息
    Object getService(String serviceName);      //2.getService获取服务信息
}
