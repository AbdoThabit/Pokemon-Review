package com.pokemonreview.api.Controllers;

import com.pokemonreview.api.DTOs.PokemonDto;
import com.pokemonreview.api.DTOs.PokemonResponse;
import com.pokemonreview.api.Services.PokemonServices.IPokemonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    @Autowired
    private IPokemonServices pokemonServices;
    @GetMapping("get-all-pokemons")
    
    public ResponseEntity<PokemonResponse> getAllPokemons(@RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
    ) {
        return ResponseEntity.ok(pokemonServices.getAllPokemon(pageNo, pageSize ));
    }
    @GetMapping("get-pokemon-by-id/{id}")
    public ResponseEntity<PokemonDto> getPokemonById(@PathVariable int id) {
        return ResponseEntity.ok(pokemonServices.getPokemonById(id));
    }
    @PostMapping("Create_Pokemon")
    public ResponseEntity<PokemonDto> CreatePokemon(@RequestBody PokemonDto pokemonDto) {
        return ResponseEntity.ok(pokemonServices.createPokemon(pokemonDto));
    }
     @PutMapping("pokemon/update")
    public ResponseEntity<PokemonDto> updatePokemon(@RequestBody PokemonDto pokemonDto) {
        PokemonDto response = pokemonServices.updatePokemon(pokemonDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("pokemon/delete/{id}")
    public ResponseEntity<PokemonDto> deletePokemon(@PathVariable int id) {
        PokemonDto dto = pokemonServices.deletePokemon(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
