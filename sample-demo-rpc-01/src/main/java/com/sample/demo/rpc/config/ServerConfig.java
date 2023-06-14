package com.sample.demo.rpc.config;

/**
 * @description: 服务配置
 * @author: sample
 * @date: 2023/6/14
 */
public class ServerConfig {

    /**
     * 注册中心地址
     */
    protected String host;

    /**
     * 注册中心端口
     */
    protected String port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
