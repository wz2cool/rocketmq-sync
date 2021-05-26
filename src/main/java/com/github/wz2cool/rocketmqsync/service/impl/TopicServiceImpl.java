package com.github.wz2cool.rocketmqsync.service.impl;

import com.github.wz2cool.rocketmqsync.service.TopicService;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingException;
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
    public List<String> listAllTopics() throws RemotingException, MQClientException, InterruptedException {
        final Set<String> topicList = mqAdminExt.fetchAllTopicList().getTopicList();
        return new ArrayList<>(topicList);
    }
}
