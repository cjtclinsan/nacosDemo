package com.example.tc.nacosdemo.demo;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;

@NacosPropertySource(dataId = "biz", groupId = "DEFAULT_VALUE", autoRefreshed = true)
public class BizController {
}