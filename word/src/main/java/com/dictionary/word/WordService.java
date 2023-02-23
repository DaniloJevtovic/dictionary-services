package com.dictionary.word;

import com.dictionary.amqp.RabbitMQMessageProducer;
import com.dictionary.clients.group.GroupClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
public class WordService {

    private final WordRepository wordRepository;
    private final GroupClient groupClient;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    public Page<Word> getAllWords(Pageable pageable) {
        return wordRepository.findAll(pageable);
    }

    public Word getWordById(Integer id) {
        return wordRepository.findById(id).orElse(null);
    }

    public Page<Word> getWordsForDic(Integer dicId, Pageable pageable) {
        return wordRepository.findByDicId(dicId, pageable);
    }

    public Page<Word> getWordsForWg(Integer wgId, Pageable pageable) {
        return wordRepository.findByWgId(wgId, pageable);
    }

    public Word saveWord(WordDTO wordDTO) {
        Word word = Word.builder()
                .word(wordDTO.word())
                .translate(wordDTO.translate())
                .description(wordDTO.description())
                .type(wordDTO.type())
                .wgId(wordDTO.wgId())
                .dicId(wordDTO.dicId())
                .build();

        wordRepository.saveAndFlush(word);

        // ideja recimo kad se doda nova rjec da postoji ms za pretragu (neki mongodb) i da se ta nova
        // rijec ubaci u tu bazu (kljuc vrijednost - rijec-prevod bez opisa i ostaloga)
        // negi globalni search
        // pretraga za kompletan rjecnik - work-search-dic (id rjecnika)
        // pretraga za grupu - work-search-dic (id grupe)
        // rabbitmmq

        return word;
    }

    public Word updateWord(Integer id, WordDTO wordDTO) {
        Word word = getWordById(id);
        word.setWord(wordDTO.word());
        word.setTranslate(wordDTO.translate());
        word.setDescription(wordDTO.description());
        word.setType(wordDTO.type());

        word.setWgId(wordDTO.wgId());

        return wordRepository.save(word);
    }

    public void deleteWord(Integer id) {
        wordRepository.deleteById(id);
    }

    @Transactional
    public Long deleteAllWordsForDic(Integer dicId) {
        return wordRepository.removeByDicId(dicId);
    }

    @Transactional
    public Long deleteAllWordsForWg(Integer wgId) {
        return wordRepository.removeByWgId(wgId);
    }
}
