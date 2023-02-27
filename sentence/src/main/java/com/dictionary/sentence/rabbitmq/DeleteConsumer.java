package com.dictionary.sentence.rabbitmq;


import com.dictionary.sentence.SentenceService;
import lombok.AllArgsConstructor;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteConsumer {

    private final SentenceService sentenceService;

    @RabbitListener(queues = "${rabbitmq.queues.sg-queue}")
    public void deleteWordsForSG(Integer sgId) {
        sentenceService.deleteAllSentencesForSg(sgId);
    }

    @RabbitListener(queues = "${rabbitmq.queues.dic-sentence-queue}")
    public void deleteWordsForDic(Integer dicId) {
        sentenceService.deleteAllSentencesForDic(dicId);
    }

}
