package com.github.wz2cool.rocketmqsync.controller;

import com.github.wz2cool.rocketmqsync.service.TopicService;
import org.apache.rocketmq.common.admin.TopicStatsTable;
import org.apache.rocketmq.common.protocol.route.TopicRouteData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("internal/topics")
public class TopicController {

    @Resource
    private TopicService topicService;

    @GetMapping
    public List<String> listAllTopics() {
        return topicService.listAllTopics();
    }

    @GetMapping("/stats")
    public TopicStatsTable stats(@RequestParam String topic) {
        return topicService.stats(topic);
    }

    @GetMapping("/route")
    public TopicRouteData route(@RequestParam String topic) {
        return topicService.route(topic);
    }
}
