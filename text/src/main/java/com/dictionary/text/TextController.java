package com.dictionary.text;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/texts")
@AllArgsConstructor
public class TextController {

    private final TextService textService;

    @GetMapping
    public Page<Text> getAllTexts(@PageableDefault(size = 5) Pageable pageable) {
        return textService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Text getTextById(@PathVariable String id) {
        return textService.findById(id);
    }

    @GetMapping("/dic/{dicId}")
    public Page<Text> getTextsForDic(@PathVariable Integer dicId, @PageableDefault(size = 5) Pageable pageable) {
        return textService.getAllForDic(dicId, pageable);
    }

    @PostMapping
    public Text saveText(@RequestBody Text text) {
        return textService.save(text);
    }

    @PatchMapping("/{id}/favorite/{fav}")
    public void updateFavorite(@PathVariable String id, @PathVariable Boolean fav) {
        textService.updateFav(id, fav);
    }

    @GetMapping("/dic/{dicId}/search/{title}")
    public Page<Text> searchByTitle(@PathVariable Integer dicId, @PathVariable String title,
                                    @PageableDefault(size = 5) Pageable pageable) {
        return textService.searchByTitle(dicId, title, pageable);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        textService.deleteText(id);
    }

    @DeleteMapping("/did/{dicId}")
    public Long deleteTextsForDic(@PathVariable Integer dicId) {
        return textService.deleteAllForDic(dicId);
    }
}
