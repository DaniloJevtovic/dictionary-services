package com.dictionary.grammar;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class GrammarService {

    private final GrammarRepository grammarRepository;

    Page<Grammar> getAllGramamrs(Pageable pageable) {
        return grammarRepository.findAll(pageable);
    }

    public Grammar getGrammarById(Integer id) {
        return grammarRepository.findById(id).orElse(null);
    }

    Page<Grammar> getGrammarsForDic(Integer dicId, Pageable pageable) {
        return grammarRepository.findByDicId(dicId, pageable);
    }

    public Grammar saveGrammar(GrammarDTO grammarDTO) {
        Grammar grammar = Grammar.builder()
                .title(grammarDTO.title())
                .content(grammarDTO.content())
                .dicId(grammarDTO.dicId())
                .build();

        return grammarRepository.save(grammar);
    }

    public Grammar updateGrammar(Integer id, GrammarDTO grammarDTO) {
        Grammar grammar = getGrammarById(id);
        grammar.setTitle(grammarDTO.title());
        grammar.setContent(grammarDTO.content());

        return grammarRepository.save(grammar);
    }

    public Page<Grammar> searchByTitle(Integer dicId, String title, Pageable pageable) {
        return grammarRepository.findByDicIdAndTitleContains(dicId, title, pageable);
    }

    public void deleteGrammar(Integer id) {
        grammarRepository.deleteById(id);
    }

    @Transactional
    public Long deleteAllGrammarsForDic(Integer dicId) {
        return grammarRepository.removeByDicId(dicId);
    }
}
