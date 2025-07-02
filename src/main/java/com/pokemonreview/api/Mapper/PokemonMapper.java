package com.pokemonreview.api.Mapper;

import com.pokemonreview.api.DTOs.PokemonDto;
import com.pokemonreview.api.DTOs.ReviewDto;
import com.pokemonreview.api.Models.Pokemon;
import java.util.List;
import java.util.stream.Collectors;

public class PokemonMapper {
public static PokemonDto toPokemonDto(Pokemon pokemon){
    PokemonDto pokemonDto = new PokemonDto(pokemon.getId(), pokemon.getName(), pokemon.getType());
    pokemon.getReviews().forEach(review -> pokemonDto.addReview(
        new ReviewDto(review.getTitle(), review.getContent(), review.getStars(), pokemon.getId())));
    return pokemonDto;
}

public static List<PokemonDto> toPokemonDtoList(List<Pokemon> pokemons){
    return pokemons.stream().map(PokemonMapper::toPokemonDto).collect(Collectors.toList());
}

}
