package com.dictionary.grammar.rabbitmq;

import com.dictionary.grammar.GrammarService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteConsumer {

    private final GrammarService grammarService;

    @RabbitListener(queues = "${rabbitmq.queues.dic-queue-all}")
    public void deleteWordsForDic(Integer dicId) {
        grammarService.deleteAllGrammarsForDic(dicId);
    }

}
