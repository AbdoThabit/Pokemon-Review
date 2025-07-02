package com.pokemonreview.api.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pokemonreview.api.Models.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
public List<Review> findByPokemonId(int pokemonId);
}
