package com.dictionary.dictionary;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/dictionaries")
@AllArgsConstructor
public class DictionaryController {

    private final DictionaryService dictionaryService;

    @GetMapping
    public List<Dictionary> getAllDictionaries() {
        return dictionaryService.getAllDictionaries();
    }

    @GetMapping("/user/{userId}")
    public List<Dictionary> getDictionariesForUser(@PathVariable Integer userId) {
        return dictionaryService.getDictionariesForUser(userId);
    }

    @PostMapping
    public Dictionary saveDictionary(@RequestBody DictionaryDTO dictionaryDTO) {
        return dictionaryService.saveDictionary(dictionaryDTO);
    }

    @PutMapping("/{id}")
    public Dictionary updateDictionary(@PathVariable Integer id, @RequestBody DictionaryDTO dictionaryDTO) {
        return dictionaryService.updateDictionary(id, dictionaryDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteDictionary(@PathVariable Integer id) {
        dictionaryService.deleteDictionary(id);
    }

}
