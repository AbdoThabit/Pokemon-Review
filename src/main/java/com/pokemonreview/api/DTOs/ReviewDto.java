package com.pokemonreview.api.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {
    private int id;
    private String title;
    private String content;
    private int start;
    private PokemonDto pokemon ;
    
    public ReviewDto(String title, String content, int start) {
        this.title = title;
        this.content = content;
        this.start = start;
    }
}
