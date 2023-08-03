package top.guoziyang.test;

import top.guoziyang.rpc.api.HelloService;
import top.guoziyang.rpc.registry.DefaultServiceRegistry;
import top.guoziyang.rpc.registry.ServiceRegistry;
import top.guoziyang.rpc.socket.server.SocketServer;

/**
 * 测试用服务提供方（服务端）
 * @author ziyang
 */
public class TestServer {

    public static void main(String[] args) {
//        HelloService helloService = new HelloServiceImpl();       //1
//        RpcServer rpcServer = new RpcServer();
//        rpcServer.register(helloService, 9000);

        HelloService helloService = new HelloServiceImpl();     //2.多注册
        ServiceRegistry serviceRegistry = new DefaultServiceRegistry();
        serviceRegistry.register(helloService);
        SocketServer socketServer = new SocketServer(serviceRegistry);
        socketServer.start(9001);
    }

}
