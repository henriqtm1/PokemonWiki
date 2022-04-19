package com.marinho.pokeapi.Model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BuilderAPI {

    private static Retrofit retrofit;

    public static Retrofit start(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;

    }

}
