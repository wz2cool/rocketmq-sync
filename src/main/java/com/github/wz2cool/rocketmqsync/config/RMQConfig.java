package com.github.wz2cool.rocketmqsync.config;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.MixAll;
import org.apache.rocketmq.tools.admin.DefaultMQAdminExt;
import org.apache.rocketmq.tools.admin.MQAdminExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RMQConfig {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Value("${rocketmq.config.namesrvAddr}")
    private String namesrvAddr;


    @Bean
    public MQAdminExt mqAdminExt() throws MQClientException {
        System.setProperty(MixAll.NAMESRV_ADDR_PROPERTY, namesrvAddr);
        logger.info("setNameSrvAddrByProperty nameSrvAddr={}", namesrvAddr);

        final DefaultMQAdminExt defaultMQAdminExt = new DefaultMQAdminExt();
        defaultMQAdminExt.start();
        return defaultMQAdminExt;
    }
}
