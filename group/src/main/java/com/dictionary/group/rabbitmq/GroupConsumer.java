package com.dictionary.group.rabbitmq;

import com.dictionary.group.GroupService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class GroupConsumer {

    private final GroupService groupService;

    @RabbitListener(queues = "${rabbitmq.queues.dic-group-queue}")
    public void deleteGroupsForDic(Integer dicId) {
        groupService.deleteAllGroupsForDic(dicId);
    }

}
