package com.example.tc.nacosdemo.demo;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * SDK方式去获取配置文件
 */
public class NacosSdkDemo {
    public static void main(String[] args) throws NacosException {
        //连接到目标服务器的地址
        //制定dateId，groupId
        String serverAddr = "localhost:8848";
        String dataId = "example";
        String groupId = "DEFAULT_GROUP";

        Properties properties = new Properties();
        properties.put("serverAddr", serverAddr);

        ConfigService configService = NacosFactory.createConfigService(properties);

        String content = configService.getConfig(dataId, groupId, 3000);

        configService.addListener(dataId, groupId, new Listener() {
            @Override
            public Executor getExecutor() {
                return null;
            }

            @Override
            public void receiveConfigInfo(String s) {
                System.out.println("configInfo:"+s);
            }
        });
    }
}