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
    private int stars;
    private int pokemonId;
    
    
    public ReviewDto(String title, String content, int stars, int pokemonId) {
        this.title = title;
        this.content = content;
        this.stars = stars;
        this.pokemonId = pokemonId;
    }
}
