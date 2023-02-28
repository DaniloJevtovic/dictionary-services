package com.dictionary.text;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TextService {

    private final TextRepository textRepository;

    public Page<Text> findAll(Pageable pageable) {
        return textRepository.findAll(pageable);
    }

    public Text findById(String id) {
        return textRepository.findById(id).orElse(null);
    }

    public Page<Text> getAllForDic(Integer dicId, Pageable pageable) {
        return textRepository.findByDicId(dicId, pageable);
    }

    public Page<Text> searchByTitle(Integer dicId, String title, Pageable pageable) {
        return textRepository.findByDicIdAndTitleContains(dicId, title, pageable);
    }

    // ako dodas id odradice update
    // bez id-a kreira novi text
    public Text save(Text text) {
        return textRepository.save(text);
    }

    public void deleteText(String textId) {
        textRepository.deleteById(textId);
    }

    public Long deleteAllForDic(Integer dicId) {
        return textRepository.deleteByDicId(dicId);
    }
}
