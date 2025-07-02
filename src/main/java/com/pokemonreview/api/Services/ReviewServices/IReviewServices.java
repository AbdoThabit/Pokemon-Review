

package com.pokemonreview.api.Services.ReviewServices;

import java.util.List;

import com.pokemonreview.api.DTOs.ReviewDto;
import com.pokemonreview.api.DTOs.ReviewResponse;

public interface IReviewServices {
    public ReviewResponse getAllReviews(int pageNo, int pageSize);
    public List<ReviewDto> getReviewByPokemonId(int pokemonId);
    public ReviewDto getReviewById(int id);
    public ReviewDto createReview(ReviewDto reviewDto);
    public ReviewDto updateReview(ReviewDto reviewDto);
    public ReviewDto deleteReview(int id);
}

