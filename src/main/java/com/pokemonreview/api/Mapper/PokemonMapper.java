package com.pokemonreview.api.Mapper;

import com.pokemonreview.api.DTOs.PokemonDto;
import com.pokemonreview.api.Models.Pokemon;
import java.util.List;
import java.util.stream.Collectors;

public class PokemonMapper {
public static PokemonDto toPokemonDto(Pokemon pokemon){
    return new PokemonDto(pokemon.getId(), pokemon.getName(), pokemon.getType());
}

public static List<PokemonDto> toPokemonDtoList(List<Pokemon> pokemons){
    return pokemons.stream().map(PokemonMapper::toPokemonDto).collect(Collectors.toList());
}
// public static Pokemon toPokemon(PokemonDto pokemonDto){
//     return new Pokemon(pokemonDto.getId(), pokemonDto.getName(), pokemonDto.getType());
// }
}
