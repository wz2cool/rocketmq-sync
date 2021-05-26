package com.github.wz2cool.rocketmqsync.service;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.List;

public interface TopicService {

    List<String> listAllTopics() throws RemotingException, MQClientException, InterruptedException;
}
