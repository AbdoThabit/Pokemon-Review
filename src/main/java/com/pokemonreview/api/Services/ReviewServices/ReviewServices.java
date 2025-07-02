package com.pokemonreview.api.Services.ReviewServices;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemonreview.api.DTOs.ReviewDto;
import com.pokemonreview.api.DTOs.ReviewResponse;
import com.pokemonreview.api.Exceptions.PokemonNotFoundException;
import com.pokemonreview.api.Exceptions.ReviewNotFoundException;
import com.pokemonreview.api.Mapper.ReviewMapper;
import com.pokemonreview.api.Models.Pokemon;
import com.pokemonreview.api.Models.Review;
import com.pokemonreview.api.Repositories.PokemonRepository;
import com.pokemonreview.api.Repositories.ReviewRepository;

@Service
public class ReviewServices implements IReviewServices {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private PokemonRepository pokemonRepository;

    @Override
    public ReviewResponse getAllReviews(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Review> reviews = reviewRepository.findAll(pageable);
        List<Review> listOfReviews = reviews.getContent();
        List<ReviewDto> content = listOfReviews.stream()
                .map(ReviewMapper::toReviewDto)
                .collect(Collectors.toList());

        ReviewResponse reviewResponse = new ReviewResponse();
        reviewResponse.setContent(content);
        reviewResponse.setPageNo(reviews.getNumber());
        reviewResponse.setPageSize(reviews.getSize());
        reviewResponse.setTotalElements(reviews.getTotalElements());
        reviewResponse.setTotalPages(reviews.getTotalPages());
        reviewResponse.setLast(reviews.isLast());

        return reviewResponse;
    }

    @Override
    public ReviewDto getReviewById(int id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new ReviewNotFoundException("Review could not be found"));
        return ReviewMapper.toReviewDto(review);
    }

    @Override
    public ReviewDto createReview(ReviewDto reviewDto) {
        Pokemon pokemon = pokemonRepository.findById(reviewDto.getPokemonId())
                    .orElseThrow(() -> new PokemonNotFoundException("Pokemon not found for the review"));
        Review review = new Review();
        review.setTitle(reviewDto.getTitle());
        review.setContent(reviewDto.getContent());
        review.setStars(reviewDto.getStars());
        review.setPokemon(pokemon);

        Review newReview = reviewRepository.save(review);
        return ReviewMapper.toReviewDto(newReview);
    }

    @Override
    public ReviewDto updateReview(ReviewDto reviewDto) {
        Review review = reviewRepository.findById(reviewDto.getId())
                .orElseThrow(() -> new ReviewNotFoundException("Review could not be updated"));
        review.setTitle(reviewDto.getTitle());
        review.setContent(reviewDto.getContent());
        review.setStars(reviewDto.getStars());
        return ReviewMapper.toReviewDto(reviewRepository.save(review));
    }

    @Override
    public ReviewDto deleteReview(int id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new ReviewNotFoundException("Review could not be deleted"));
        reviewRepository.deleteById(id);
        return ReviewMapper.toReviewDto(review);
    }

    @Override
    public List<ReviewDto> getReviewByPokemonId(int pokemonId) {
        List<Review> reviews = reviewRepository.findByPokemonId(pokemonId);
    
        return reviews.stream()
                .map(ReviewMapper::toReviewDto)
                .collect(Collectors.toList());
    }
}
