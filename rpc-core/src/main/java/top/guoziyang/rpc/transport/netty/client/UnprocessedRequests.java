package top.guoziyang.rpc.transport.netty.client;

import top.guoziyang.rpc.entity.RpcResponse;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 对request和rpcResponse做一些异步编程操作
 * @author ziyang
 */
public class UnprocessedRequests {

    private static ConcurrentHashMap<String, CompletableFuture<RpcResponse>> unprocessedResponseFutures = new ConcurrentHashMap<>();

    //将一个未处理的响应添加到unprocessedResponseFutures中
    public void put(String requestId, CompletableFuture<RpcResponse> future) {
        unprocessedResponseFutures.put(requestId, future);
    }

    //从unprocessedResponseFutures中移除一个已处理的响应
    public void remove(String requestId) {
        unprocessedResponseFutures.remove(requestId);
    }

    //用于完成一个响应的处理
    //首先从unprocessedResponseFutures中移除对应的响应，然后调用CompletableFuture的complete()方法来设置响应的结果值。如果找不到对应的响应，它会抛出一个IllegalStateException。
    public void complete(RpcResponse rpcResponse) {
        //CompletableFuture支持异步编程
        CompletableFuture<RpcResponse> future = unprocessedResponseFutures.remove(rpcResponse.getRequestId());
        if (null != future) {
            future.complete(rpcResponse);
        } else {
            throw new IllegalStateException();
        }
    }

}
