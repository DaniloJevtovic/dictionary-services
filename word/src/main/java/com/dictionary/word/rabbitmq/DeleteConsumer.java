package com.dictionary.word.rabbitmq;

import com.dictionary.word.WordService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteConsumer {

    private final WordService wordService;

    @RabbitListener(queues = "${rabbitmq.queues.wg-queue}")
    public void deleteWordsForWG(Integer wgId) {
        wordService.deleteAllWordsForWg(wgId);
    }

    @RabbitListener(queues = "${rabbitmq.queues.dic-queue-all}")
    public void deleteWordsForDic(Integer dicId) {
        wordService.deleteAllWordsForDic(dicId);
    }

}
