package com.dictionary.text.rabbitmq;

import com.dictionary.text.TextService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteConsumer {

    private final TextService textService;

    @RabbitListener(queues = "${rabbitmq.queues.dic-text-queue}")
    public void deleteTextsForDic(Integer dicId) {
        textService.deleteAllForDic(dicId);
    }

}
