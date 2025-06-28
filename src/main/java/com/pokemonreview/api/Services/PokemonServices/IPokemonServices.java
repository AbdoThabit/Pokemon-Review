package com.pokemonreview.api.Services.PokemonServices;

import com.pokemonreview.api.DTOs.PokemonDto;
import com.pokemonreview.api.DTOs.PokemonResponse;

// import java.util.List;

public interface IPokemonServices {
    public PokemonResponse getAllPokemon(int pageNo, int pageSize);
    public PokemonDto getPokemonById(int id);
    public PokemonDto createPokemon(PokemonDto pokemonDto);
    public PokemonDto updatePokemon(PokemonDto pokemonDto);
    public PokemonDto deletePokemon(int id);
}
