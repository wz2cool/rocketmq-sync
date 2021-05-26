package com.github.wz2cool.rocketmqsync.service.impl;

import com.github.wz2cool.rocketmqsync.service.TopicService;
import com.google.common.base.Throwables;
import org.apache.rocketmq.common.admin.TopicStatsTable;
import org.apache.rocketmq.common.protocol.route.TopicRouteData;
import org.apache.rocketmq.tools.admin.MQAdminExt;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class TopicServiceImpl implements TopicService {

    @Resource
    private MQAdminExt mqAdminExt;

    @Override
    public List<String> listAllTopics() {
        try {
            Set<String> topicList = mqAdminExt.fetchAllTopicList().getTopicList();
            return new ArrayList<>(topicList);
        } catch (Exception ex) {
            throw Throwables.propagate(ex);
        }
    }

    @Override
    public TopicStatsTable stats(String topic) {
        try {
            return mqAdminExt.examineTopicStats(topic);
        } catch (Exception e) {
            throw Throwables.propagate(e);
        }
    }

    @Override
    public TopicRouteData route(String topic) {
        try {
            return mqAdminExt.examineTopicRouteInfo(topic);
        } catch (Exception ex) {
            throw Throwables.propagate(ex);
        }
    }
}
