package com.sample.demo.rpc.config;

/**
 * @description: 消费者配置
 * @author: sample
 * @date: 2023/6/14
 */
public class ConsumerConfig<T> {

    /**
     * 接口
     */
    private String nozzle;

    /**
     * 别名
     */
    private String alias;

    protected synchronized T refer() {
        System.out.format("消费者信息->[接口：%s][别名：%s]", nozzle, alias);
        return null;
    }

}
