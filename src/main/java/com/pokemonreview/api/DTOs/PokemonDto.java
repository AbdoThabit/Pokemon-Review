package com.pokemonreview.api.DTOs;

import java.util.ArrayList;

import lombok.Data;

@Data
public class PokemonDto {
    private int id;
    private String name;
    private String type;
    private ArrayList<ReviewDto> reviews = new ArrayList<>();

    public PokemonDto(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public void addReview(ReviewDto review) {
        this.reviews.add(review);
    }
}
