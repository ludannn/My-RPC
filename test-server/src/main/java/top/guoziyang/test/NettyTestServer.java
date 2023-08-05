package top.guoziyang.test;

import top.guoziyang.rpc.api.HelloService;
import top.guoziyang.rpc.netty.server.NettyServer;
import top.guoziyang.rpc.provider.ServiceProvider;
import top.guoziyang.rpc.serializer.ProtobufSerializer;

/**
 * 测试用Netty服务提供者（服务端）
 *
 * @author ziyang
 */
public class NettyTestServer {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
//        ServiceProvider registry = new DefaultServiceProvider();
//        registry.register(helloService);      //放在publishService中了
//        NettyServer server = new NettyServer();
        NettyServer server = new NettyServer("127.0.0.1", 9999); //5.构造方式的改变
        server.setSerializer(new ProtobufSerializer());
//        server.start(9999); //5.放在NettyServer的publishService中
        server.publishService(helloService, HelloService.class);
    }

}
