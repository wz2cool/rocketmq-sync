package com.github.wz2cool.rocketmqsync.controller;

import com.github.wz2cool.rocketmqsync.service.TopicService;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("internal/topics")
public class TopicController {

    @Resource
    private TopicService topicService;

    @GetMapping
    public List<String> listAllTopics() throws RemotingException, MQClientException, InterruptedException {
        return topicService.listAllTopics();
    }
}
