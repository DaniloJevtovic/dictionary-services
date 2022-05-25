package com.dictionary.word;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/words")
@AllArgsConstructor
public class WordController {

    private final WordService wordService;

    @GetMapping
    public Page<Word> getAllWords(Pageable pageable) {
        return wordService.getAllWords(pageable);
    }

    @GetMapping("/{id}")
    public Word getWordById(@PathVariable Integer id) {
        return wordService.getWordById(id);
    }

    @GetMapping("/dic/{dicId}")
    public Page<Word> getWordsForDic(@PathVariable Integer dicId, Pageable pageable) {
        return wordService.getWordsForDic(dicId, pageable);
    }

    @GetMapping("/wg/{wgId}")
    public Page<Word> getWordsForWG(@PathVariable Integer wgId, Pageable pageable) {
        return wordService.getWordsForWg(wgId, pageable);
    }

    @PostMapping
    public Word saveWord(@RequestBody WordDTO wordDTO) {
        return wordService.saveWord(wordDTO);
    }

    @PutMapping("/{id}")
    public Word updateWord(@PathVariable Integer id, @RequestBody WordDTO wordDTO) {
        return wordService.updateWord(id, wordDTO);
    }

    @DeleteMapping("/{id}/wg/{wgId}")
    public void deleteWord(@PathVariable Integer id, @PathVariable Integer wgId) {
        wordService.deleteWord(id, wgId);
    }

    @DeleteMapping("/dic/{dicId}")
    public Long deleteAllWordsForDic(@PathVariable Integer dicId) {
        return wordService.deleteAllWordsForDic(dicId);
    }

    @DeleteMapping("/wg/{wgId}")
    public Long deleteAllWordsForWg(@PathVariable Integer wgId) {
        return wordService.deleteAllWordsForWg(wgId);
    }
}