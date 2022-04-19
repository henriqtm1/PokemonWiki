package com.marinho.pokeapi.Model;

import com.marinho.pokeapi.Model.Pokemon;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonService {

    @GET("/api/v2/pokemon/{npoke}/")
    Call<Pokemon> getPokemon(@Path("npoke")String npoke);



}
