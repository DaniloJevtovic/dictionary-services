package com.dictionary.sentence;

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
public class SentenceService {

    private final SentenceRepository sentenceRepository;
    private final GroupClient groupClient;

    public Page<Sentence> getAllSentences(Pageable pageable) {
        return sentenceRepository.findAll(pageable);
    }

    public Sentence getSentenceById(Integer id) {
        return sentenceRepository.findById(id).orElse(null);
    }

    public Page<Sentence> getSentencesForDic(Integer dicId, Pageable pageable) {
        return sentenceRepository.findByDicId(dicId, pageable);
    }

    public Page<Sentence> getSentencesForSg(Integer sgId, Pageable pageable) {
        return sentenceRepository.findBySgId(sgId, pageable);
    }

    public Sentence saveSentence(SentenceDTO sentenceDTO) {
        Sentence sentence = Sentence.builder()
                .sentence(sentenceDTO.sentence())
                .translate(sentenceDTO.translate())
                .description(sentenceDTO.description())
                .sgId(sentenceDTO.sgId())
                .dicId(sentenceDTO.dicId())
                .build();

        groupClient.increaseNumOfItems(sentenceDTO.sgId());

        return sentenceRepository.save(sentence);
    }

    public Sentence updateSentence(Integer id, SentenceDTO sentenceDTO) {
        Sentence sentence = getSentenceById(id);
        sentence.setSentence(sentenceDTO.sentence());
        sentence.setTranslate(sentenceDTO.translate());
        sentence.setDescription(sentenceDTO.description());

        if (!sentence.getSgId().equals(sentenceDTO.sgId())) {
            log.info("promjena grupe");
            groupClient.decreaseNumOfItems(sentence.getSgId());
            groupClient.increaseNumOfItems(sentenceDTO.sgId());

            sentence.setSgId(sentenceDTO.sgId());
        }

        return sentenceRepository.save(sentence);
    }

    public void deleteSentence(Integer id, Integer sgId) {
        sentenceRepository.deleteById(id);
        groupClient.decreaseNumOfItems(sgId);   // smanjenje broja recenica u grupi
    }

    @Transactional
    public Long deleteAllWordsForDic(Integer dicId) {
        return sentenceRepository.removeByDicId(dicId);
    }

    @Transactional
    public Long deleteAllSentencesForSg(Integer sgId) {
        return sentenceRepository.removeBySgId(sgId);
    }
}