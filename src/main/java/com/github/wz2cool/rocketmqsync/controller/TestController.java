package com.github.wz2cool.rocketmqsync.controller;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.protocol.body.TopicList;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.apache.rocketmq.tools.admin.MQAdminExt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {

    @Resource
    private MQAdminExt mqAdminExt;

    @GetMapping("topics")
    public List<String> listAllTopics() throws RemotingException, MQClientException, InterruptedException {
        final TopicList topicList = mqAdminExt.fetchAllTopicList();
        return new ArrayList<>(topicList.getTopicList());
    }

}
