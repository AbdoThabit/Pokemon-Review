package com.pokemonreview.api.Services.PokemonServices;

import com.pokemonreview.api.DTOs.PokemonDto;
import com.pokemonreview.api.DTOs.PokemonResponse;
import com.pokemonreview.api.Exceptions.PokemonNotFoundException;
import com.pokemonreview.api.Mapper.PokemonMapper;
import com.pokemonreview.api.Models.Pokemon;
import com.pokemonreview.api.Repositories.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Service
class PockemonServices implements IPokemonServices {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Override
    public PokemonResponse getAllPokemon(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Pokemon> pokemons = pokemonRepository.findAll(pageable);
        List<Pokemon> listOfPokemon = pokemons.getContent();
        List<PokemonDto> content = listOfPokemon.stream().map(PokemonMapper::toPokemonDto).collect(Collectors.toList());

        PokemonResponse pokemonResponse = new PokemonResponse();
        pokemonResponse.setContent(content);
        pokemonResponse.setPageNo(pokemons.getNumber());
        pokemonResponse.setPageSize(pokemons.getSize());
        pokemonResponse.setTotalElements(pokemons.getTotalElements());
        pokemonResponse.setTotalPages(pokemons.getTotalPages());
        pokemonResponse.setLast(pokemons.isLast());

        return pokemonResponse;
    }

    @Override
    public PokemonDto getPokemonById(int id) {
        Pokemon pokemon = pokemonRepository.findById(id).orElseThrow(() -> new PokemonNotFoundException("Pokemon could not be updated"));
        return PokemonMapper.toPokemonDto(pokemon);
    }

    @Override
    public PokemonDto createPokemon(PokemonDto pokemonDto) {
      Pokemon pokemon = new Pokemon();
        pokemon.setName(pokemonDto.getName());
        pokemon.setType(pokemonDto.getType());

        Pokemon newPokemon = pokemonRepository.save(pokemon);

        PokemonDto pokemonResponse = PokemonMapper.toPokemonDto(newPokemon);
        return pokemonResponse;
    }

    @Override
    public PokemonDto updatePokemon(PokemonDto pokemonDto) {
        var pokemon = pokemonRepository.findById(pokemonDto.getId()).orElseThrow(() -> new PokemonNotFoundException("Pokemon could not be updated"));;
        pokemon.setName(pokemonDto.getName());
        pokemon.setType(pokemonDto.getType());
        return PokemonMapper.toPokemonDto(pokemonRepository.save(pokemon));
    }

    @Override
    public PokemonDto deletePokemon(int id) {
        Pokemon pokemon = pokemonRepository.findById(id).orElseThrow(() -> new PokemonNotFoundException("Pokemon could not be updated"));
        pokemonRepository.deleteById(id);
        return PokemonMapper.toPokemonDto(pokemon);
    }
}
