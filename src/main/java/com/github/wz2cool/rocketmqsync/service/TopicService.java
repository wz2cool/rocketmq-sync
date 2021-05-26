package com.github.wz2cool.rocketmqsync.service;

import org.apache.rocketmq.common.admin.TopicStatsTable;
import org.apache.rocketmq.common.protocol.route.TopicRouteData;

import java.util.List;

public interface TopicService {

    List<String> listAllTopics();

    TopicStatsTable stats(String topic);

    TopicRouteData route(String topic);
}
