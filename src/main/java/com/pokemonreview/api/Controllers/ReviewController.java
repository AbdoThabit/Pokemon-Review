package com.pokemonreview.api.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pokemonreview.api.DTOs.ReviewDto;
import com.pokemonreview.api.DTOs.ReviewResponse;
import com.pokemonreview.api.Services.ReviewServices.ReviewServices;



@Controller
@RequestMapping("/Review")


public class ReviewController {

    @Autowired
    private ReviewServices reviewServices;
    @GetMapping("get-all-reviews")
    public ResponseEntity<ReviewResponse> getAllReviews(
        @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
        @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
    ) {
        return ResponseEntity.ok(reviewServices.getAllReviews(pageNo, pageSize));
    }
    @GetMapping("get-reviews-by-pokemon-id/{id}")
    public ResponseEntity<List<ReviewDto>> getReviewsByPokemonId(@PathVariable int pokemonId) {
        return ResponseEntity.ok(reviewServices.getReviewByPokemonId(pokemonId));
    }

    @GetMapping("get-review-by-id/{id}")
    public ResponseEntity<ReviewDto> getReviewById(@PathVariable int id) {
        return ResponseEntity.ok(reviewServices.getReviewById(id));
    }

    @PostMapping("create-review")
    public ResponseEntity<ReviewDto> createReview(@RequestBody ReviewDto reviewDto) {
        return ResponseEntity.ok(reviewServices.createReview(reviewDto));
    }

    @PutMapping("review/update")
    public ResponseEntity<ReviewDto> updateReview(@RequestBody ReviewDto reviewDto) {
        ReviewDto response = reviewServices.updateReview(reviewDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("review/delete/{id}")
    public ResponseEntity<ReviewDto> deleteReview(@PathVariable int id) {
        ReviewDto dto = reviewServices.deleteReview(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
