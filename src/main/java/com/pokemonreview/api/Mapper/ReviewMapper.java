package com.pokemonreview.api.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.pokemonreview.api.DTOs.PokemonDto;
import com.pokemonreview.api.DTOs.ReviewDto;
import com.pokemonreview.api.Models.Review;

public class ReviewMapper {
public static ReviewDto toReviewDto(Review review) {
    PokemonDto pokemonDto = new PokemonDto(review.getPokemon().getId(), review.getPokemon().getName(), review.getPokemon().getType());
    return new ReviewDto(review.getId(), review.getTitle(), review.getContent(), review.getStars(), pokemonDto.getId());
}
public static List<ReviewDto> toReviewDtoList(List<Review> reviews){
    return reviews.stream().map(ReviewMapper::toReviewDto).collect(Collectors.toList());
}
}
