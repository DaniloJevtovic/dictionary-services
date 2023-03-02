package com.dictionary.sentence;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public Page<Sentence> getSentencesForDic(@PathVariable Integer dicId, @PageableDefault(size = 10) Pageable pageable) {
        return sentenceService.getSentencesForDic(dicId, pageable);
    }

    @GetMapping("/sg/{sgId}")
    public Page<Sentence> getSentencesForSg(@PathVariable Integer sgId, @PageableDefault(size = 10) Pageable pageable) {
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

    @PatchMapping("/{id}/favorite/{fav}")
    public void updateFavorite(@PathVariable Integer id, @PathVariable Boolean fav) {
        sentenceService.updateFavorite(id, fav);
    }

    @GetMapping("/dic/{dicId}/search/{value}")
    public Page<Sentence> searchInDic(@PathVariable Integer dicId, @PathVariable String value, Pageable pageable) {
        return sentenceService.searchdInDic(dicId, value, pageable);
    }

    @GetMapping("/group/{sgId}/search/{value}")
    public Page<Sentence> searchInGroup(@PathVariable Integer wgId, @PathVariable String value, Pageable pageable) {
        return sentenceService.searchInGroup(wgId, value, pageable);
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
