package com.marinho.pokeapi.viewmodel;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.marinho.pokeapi.Model.BuilderAPI;
import com.marinho.pokeapi.Model.Pokemon;
import com.marinho.pokeapi.Model.PokemonService;
import com.marinho.pokeapi.View.MainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {

    private PokemonService pokemonService;

    //Pokemon digitado
    private MutableLiveData<String> mutable_pokemonDigitado = new MutableLiveData<>();
    public LiveData<String> liveData_pokemonDigitado = mutable_pokemonDigitado;

    //Pokemon Nome
    private MutableLiveData<String> mutable_nomePokemon = new MutableLiveData<>();
    public LiveData<String> liveData_nomePokemon = mutable_nomePokemon;

    //Pokemon foto
    private MutableLiveData<String> mutable_fotoPokemon = new MutableLiveData<>();
    public LiveData<String> liveData_fotoPokemon = mutable_fotoPokemon;

    //Pokemon skill1
    private MutableLiveData<String> mutable_pokemonSkill1 = new MutableLiveData<>();
    public LiveData<String> liveData_pokemonSkill1 = mutable_pokemonSkill1;

    //Pokemon skill2
    private MutableLiveData<String> mutable_pokemonSkill2 = new MutableLiveData<>();
    public LiveData<String> liveData_pokemonSkill2 = mutable_pokemonSkill2;

    //Pokemon type
    private MutableLiveData<String> mutable_pokemonType = new MutableLiveData<>();
    public LiveData<String> liveData_pokemonType = mutable_pokemonType;

    //Pokemon type
    private MutableLiveData<Boolean> mutable_boolean = new MutableLiveData<>();
    public LiveData<Boolean> liveData_boolean = mutable_boolean;


    public void startPokeApi(String nomePokemon){

        pokemonService = BuilderAPI.start().create(PokemonService.class);
        Call<Pokemon> call = pokemonService.getPokemon(nomePokemon);

        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {

                if (response.isSuccessful()) {

                    mutable_boolean.setValue(true);

                    Pokemon pokemon = response.body();

                    //Nome Pokemon digitado
                    mutable_pokemonDigitado.setValue(nomePokemon);

                    //Name Pokemon
                    mutable_nomePokemon.setValue(pokemon.getName());

                    //Foto Pokemon
                    mutable_fotoPokemon.setValue(pokemon.getSprites().getFront_default());

                    //habilidades pokemon
                    mutable_pokemonSkill1.setValue(pokemon.abilities.get(0).ability.getName());

                    //habilidades pokemon
                    mutable_pokemonSkill2.setValue(pokemon.abilities.get(1).ability.getName());

                    //Tipo do pokemon
                    mutable_pokemonType.setValue(pokemon.types.get(0).type.getName());

                }else{
                    mutable_boolean.setValue(false);
                }
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {

            }
        });

    }


}
