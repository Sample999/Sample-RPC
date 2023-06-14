package com.sample.demo.rpc.network.future;

import com.sample.demo.rpc.network.msg.Response;

import java.util.concurrent.Future;


public interface WriteFuture<T> extends Future<T> {

    Throwable cause();

    void setCause(Throwable cause);

    boolean isWriteSuccess();

    void setWriteResult(boolean result);

    String requestId();

    T response();

    void setResponse(Response response);

    boolean isTimeout();


}
