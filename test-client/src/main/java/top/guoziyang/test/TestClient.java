package top.guoziyang.test;

import top.guoziyang.rpc.api.HelloObject;
import top.guoziyang.rpc.api.HelloService;
import top.guoziyang.rpc.RpcClientProxy;

/**
 * 测试用消费者（客户端）
 * @author ziyang
 */
public class TestClient {

    public static void main(String[] args) { //3.开始弃用
//        RpcClientProxy proxy = new RpcClientProxy("127.0.0.1", 9001);
//        HelloService helloService = proxy.getProxy(HelloService.class);
//        HelloObject object = new HelloObject(12, "This is a message");
//        String res = helloService.hello(object);
//        System.out.println(res);
    }

}
