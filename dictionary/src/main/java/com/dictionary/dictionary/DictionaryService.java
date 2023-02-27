package com.dictionary.dictionary;

import com.dictionary.amqp.RabbitMQMessageProducer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class DictionaryService {

    private final DictionaryRepository dictionaryRepository;

    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    public List<Dictionary> getAllDictionaries() {
        return dictionaryRepository.findAll();
    }

    public Dictionary getDictionaryById(Integer dicId) {
        return dictionaryRepository.findById(dicId).orElse(null);
    }

    public List<Dictionary> getDictionariesForUser(Integer userId) {
        return dictionaryRepository.findByUserId(userId);
    }

    public Dictionary saveDictionary(DictionaryDTO dictionaryDTO) {

        Dictionary dictionary = Dictionary.builder()
                .name(dictionaryDTO.name())
                .description(dictionaryDTO.description())
                .color(dictionaryDTO.color())
                .userId(dictionaryDTO.userId())
                .build();

        return dictionaryRepository.save(dictionary);
    }

    public Dictionary updateDictionary(Integer id, DictionaryDTO dictionaryDTO) {
        Dictionary dictionary = getDictionaryById(id);
        dictionary.setName(dictionaryDTO.name());
        dictionary.setDescription(dictionaryDTO.description());
        dictionary.setColor(dictionaryDTO.color());
        return dictionaryRepository.save(dictionary);
    }

    public void deleteDictionary(Integer id) {
        // brisanje svega iz rjecnika - rjeci, recenica i gramatike
        rabbitMQMessageProducer.publish(id, "delete.dic.all", "del-dic.routing-key");

        dictionaryRepository.deleteById(id);
    }
}
