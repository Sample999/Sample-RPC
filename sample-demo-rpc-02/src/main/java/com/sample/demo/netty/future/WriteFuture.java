package com.sample.demo.netty.future;

import com.sample.demo.netty.msg.Response;

import java.util.concurrent.Future;

/**
 * @description:
 * @author: sample
 * @date: 2023/6/13
 */
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
