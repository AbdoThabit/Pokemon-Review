package com.pokemonreview.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pokemonreview.api.Models.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
