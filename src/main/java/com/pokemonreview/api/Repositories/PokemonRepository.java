package com.pokemonreview.api.Repositories;

import com.pokemonreview.api.Models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {

}
