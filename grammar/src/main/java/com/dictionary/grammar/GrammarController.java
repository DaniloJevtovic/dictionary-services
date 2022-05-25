package com.dictionary.grammar;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/grammars")
@AllArgsConstructor
public class GrammarController {

    private final GrammarService grammarService;

    @GetMapping
    public Page<Grammar> getAllGrammars(Pageable pageable) {
        return grammarService.getAllGramamrs(pageable);
    }

    @GetMapping("/{id}")
    public Grammar getGrammarById(@PathVariable Integer id) {
        return grammarService.getGrammarById(id);
    }

    @GetMapping("/dic/{dicId}")
    public Page<Grammar> getGrammarsForDic(@PathVariable Integer dicId, Pageable pageable) {
        return grammarService.getGrammarsForDic(dicId, pageable);
    }

    @PostMapping
    public Grammar saveGrammar(@RequestBody GrammarDTO grammarDTO) {
        return grammarService.saveGrammar(grammarDTO);
    }

    @PutMapping("/{id}")
    public Grammar updateGrammar(@PathVariable Integer id, @RequestBody GrammarDTO grammarDTO) {
        return  grammarService.updateGrammar(id, grammarDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteGrammar(@PathVariable Integer id) {
        grammarService.deleteGrammar(id);
    }

    @DeleteMapping("/dic/{dicId}")
    public Long deleteAllGrammarsForDic(@PathVariable Integer dicId) {
        return grammarService.deleteAllGrammarsForDic(dicId);
    }

}
