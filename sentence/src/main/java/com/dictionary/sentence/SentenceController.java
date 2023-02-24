package com.dictionary.sentence;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/sentences")
@AllArgsConstructor
public class SentenceController {

    private final SentenceService sentenceService;

    @GetMapping
    public Page<Sentence> getAllSentences(Pageable pageable) {
        return sentenceService.getAllSentences(pageable);
    }

    @GetMapping("/{id}")
    public Sentence getSentenceById(@PathVariable Integer id) {
        return sentenceService.getSentenceById(id);
    }

    @GetMapping("/dic/{dicId}")
    public Page<Sentence> getSentencesForDic(@PathVariable Integer dicId, Pageable pageable) {
        return sentenceService.getSentencesForDic(dicId, pageable);
    }

    @GetMapping("/sg/{sgId}")
    public Page<Sentence> getSentencesForSg(@PathVariable Integer sgId, Pageable pageable) {
        return sentenceService.getSentencesForSg(sgId, pageable);
    }

    @PostMapping
    public Sentence saveSentence(@RequestBody SentenceDTO sentenceDTO) {
        return sentenceService.saveSentence(sentenceDTO);
    }

    @PutMapping("/{id}")
    public Sentence updateSentence(@PathVariable Integer id, @RequestBody SentenceDTO sentenceDTO) {
        return sentenceService.updateSentence(id, sentenceDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteSentence(@PathVariable Integer id) {
        sentenceService.deleteSentence(id);
    }

    @DeleteMapping("/dic/{dicId}")
    public Long deleteAllSentencesForDic(@PathVariable Integer dicId) {
        return sentenceService.deleteAllSentencesForDic(dicId);
    }

    @DeleteMapping("/sg/{sgId}")
    public Long deleteAllSentencesForSg(@PathVariable Integer sgId) {
        return sentenceService.deleteAllSentencesForSg(sgId);
    }

}
