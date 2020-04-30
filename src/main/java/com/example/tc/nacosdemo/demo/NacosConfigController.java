package com.example.tc.nacosdemo.demo;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@NacosPropertySource(dataId = "example", groupId = "DEFAULT_GROUP", autoRefreshed = true)
@RestController
public class NacosConfigController {
    /**
     * 当前的info这个属性，会去nacos-server找到对应的info这个属性
     * 高可用性
     * hello Nacos 表示本地属性（降级属性）
     */
    @NacosValue(value = "${info:hello nacos}", autoRefreshed = true)
    private String info;

    @GetMapping("/get")
    public String get(){
        return info;
    }
}