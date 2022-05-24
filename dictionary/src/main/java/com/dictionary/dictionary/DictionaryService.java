package com.dictionary.dictionary;

import com.dictionary.clients.group.GroupClient;
import com.dictionary.clients.word.WordClient;
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
    private final ModelMapper modelMapper;
    private final WordClient wordClient;
    private final GroupClient groupClient;

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
        //brisanje svih grupa -> brisanje svih rjeci, recenica i gramatike
        Long brRjeci = wordClient.deleteAllWordsForDic(id);
        log.info("Obrisano ukupno {} rjeci", brRjeci);

        Long brGrupa = groupClient.deleteAllGroupsForDic(id);
        log.info("Obrisao ukupno {} grupa", brGrupa);

        dictionaryRepository.deleteById(id);
    }
}
