package com.marinho.pokeapi.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.marinho.pokeapi.R;
import com.marinho.pokeapi.viewmodel.MainViewModel;
import com.marinho.pokeapi.databinding.ActivityMainBinding;
import com.marinho.pokeapi.Model.imagensAPI;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ImageView fotoapi;
    private ActivityMainBinding binding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        fotoapi = findViewById(R.id.image_api);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        binding.setMViewModel(viewModel);

        viewModel.liveData_pokemonDigitado.observe(this, nomeDigitado -> {
            binding.edtTxtPokemon.setText(nomeDigitado);
        });

        viewModel.liveData_nomePokemon.observe(this, nome -> {
            binding.txtPokemon.setText(nome);
        });

        viewModel.liveData_fotoPokemon.observe(this, foto -> {
            imagensAPI.picasso(fotoapi, foto);
        });

        viewModel.liveData_pokemonSkill1.observe(this, skill1 -> {
            binding.texthability1.setText(skill1);
        });

        viewModel.liveData_pokemonSkill2.observe(this, skill2 -> {
            binding.texthability2.setText(skill2);
        });

        viewModel.liveData_boolean.observe(this, verifica -> {
            if (verifica == false){
                binding.textInputLayout.setError("Preencha com um pokémon válido");
            }else{
                binding.textInputLayout.setError(null);
            }
        });

        viewModel.liveData_pokemonType.observe(this, type -> {
            binding.texttipoPokemon.setText(type);
            Condicoes(type);
            Log.i("opa", type);
        });


        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.startPokeApi(binding.edtTxtPokemon.getText().toString().toLowerCase(Locale.ROOT));
            }
        });

    }

    public void Condicoes(String type){

        if (type.equals("grass") || type == "grass") {
            binding.txtPokemon.setTextColor(getResources().getColor(R.color.grass));
            binding.texthability1.setTextColor(getResources().getColor(R.color.grass));
            binding.texthability2.setTextColor(getResources().getColor(R.color.grass));
            binding.texttipoPokemon.setTextColor(getResources().getColor(R.color.grass));


        }else if (type.equals("fire") || type == "fire") {
            binding.txtPokemon.setTextColor(getResources().getColor(R.color.fire));
            binding.texthability1.setTextColor(getResources().getColor(R.color.fire));
            binding.texthability2.setTextColor(getResources().getColor(R.color.fire));
            binding.texttipoPokemon.setTextColor(getResources().getColor(R.color.fire));

        }else if (type.equals("water") || type == "water") {
            binding.txtPokemon.setTextColor(getResources().getColor(R.color.water));
            binding.texthability1.setTextColor(getResources().getColor(R.color.water));
            binding.texthability2.setTextColor(getResources().getColor(R.color.water));
            binding.texttipoPokemon.setTextColor(getResources().getColor(R.color.water));

        }else if (type.equals("bug") || type == "bug") {
            binding.txtPokemon.setTextColor(getResources().getColor(R.color.bug));
            binding.texthability1.setTextColor(getResources().getColor(R.color.bug));
            binding.texthability2.setTextColor(getResources().getColor(R.color.bug));
            binding.texttipoPokemon.setTextColor(getResources().getColor(R.color.bug));

        }else if (type.equals("normal") || type == "normal") {
            binding.txtPokemon.setTextColor(getResources().getColor(R.color.normal));
            binding.texthability1.setTextColor(getResources().getColor(R.color.normal));
            binding.texthability2.setTextColor(getResources().getColor(R.color.normal));
            binding.texttipoPokemon.setTextColor(getResources().getColor(R.color.normal));

        }else if (type.equals("poison") || type == "poison") {
            binding.txtPokemon.setTextColor(getResources().getColor(R.color.poison));
            binding.texthability1.setTextColor(getResources().getColor(R.color.poison));
            binding.texthability2.setTextColor(getResources().getColor(R.color.poison));
            binding.texttipoPokemon.setTextColor(getResources().getColor(R.color.poison));

        }else if (type.equals("electric") || type == "electric") {
            binding.txtPokemon.setTextColor(getResources().getColor(R.color.electric));
            binding.texthability1.setTextColor(getResources().getColor(R.color.electric));
            binding.texthability2.setTextColor(getResources().getColor(R.color.electric));
            binding.texttipoPokemon.setTextColor(getResources().getColor(R.color.electric));

        }else if (type.equals("ground") || type == "ground") {
            binding.txtPokemon.setTextColor(getResources().getColor(R.color.ground));
            binding.texthability1.setTextColor(getResources().getColor(R.color.ground));
            binding.texthability2.setTextColor(getResources().getColor(R.color.ground));
            binding.texttipoPokemon.setTextColor(getResources().getColor(R.color.ground));

        }else if (type.equals("fighting") || type == "fighting") {
            binding.txtPokemon.setTextColor(getResources().getColor(R.color.fighting));
            binding.texthability1.setTextColor(getResources().getColor(R.color.fighting));
            binding.texthability2.setTextColor(getResources().getColor(R.color.fighting));
            binding.texttipoPokemon.setTextColor(getResources().getColor(R.color.fighting));

        }else if (type.equals("psychic") || type == "psychic") {
            binding.txtPokemon.setTextColor(getResources().getColor(R.color.psychic));
            binding.texthability1.setTextColor(getResources().getColor(R.color.psychic));
            binding.texthability2.setTextColor(getResources().getColor(R.color.psychic));
            binding.texttipoPokemon.setTextColor(getResources().getColor(R.color.psychic));

        }else if (type.equals("rock") || type == "rock") {
            binding.txtPokemon.setTextColor(getResources().getColor(R.color.rock));
            binding.texthability1.setTextColor(getResources().getColor(R.color.rock));
            binding.texthability2.setTextColor(getResources().getColor(R.color.rock));
            binding.texttipoPokemon.setTextColor(getResources().getColor(R.color.rock));

        }else if (type.equals("flying") || type == "flying") {
            binding.txtPokemon.setTextColor(getResources().getColor(R.color.flying));
            binding.texthability1.setTextColor(getResources().getColor(R.color.flying));
            binding.texthability2.setTextColor(getResources().getColor(R.color.flying));
            binding.texttipoPokemon.setTextColor(getResources().getColor(R.color.flying));

        }else if (type.equals("ghost") || type == "ghost") {
            binding.txtPokemon.setTextColor(getResources().getColor(R.color.ghost));
            binding.texthability1.setTextColor(getResources().getColor(R.color.ghost));
            binding.texthability2.setTextColor(getResources().getColor(R.color.ghost));
            binding.texttipoPokemon.setTextColor(getResources().getColor(R.color.ghost));

        }else if (type.equals("ice") || type == "ice") {
            binding.txtPokemon.setTextColor(getResources().getColor(R.color.ice));
            binding.texthability1.setTextColor(getResources().getColor(R.color.ice));
            binding.texthability2.setTextColor(getResources().getColor(R.color.ice));
            binding.texttipoPokemon.setTextColor(getResources().getColor(R.color.ice));

        }else if (type.equals("dragon") || type == "dragon") {
            binding.txtPokemon.setTextColor(getResources().getColor(R.color.dragon));
            binding.texthability1.setTextColor(getResources().getColor(R.color.dragon));
            binding.texthability2.setTextColor(getResources().getColor(R.color.dragon));
            binding.texttipoPokemon.setTextColor(getResources().getColor(R.color.dragon));

        }else if (type.equals("steel") || type == "steel") {
            binding.txtPokemon.setTextColor(getResources().getColor(R.color.steel));
            binding.texthability1.setTextColor(getResources().getColor(R.color.steel));
            binding.texthability2.setTextColor(getResources().getColor(R.color.steel));
            binding.texttipoPokemon.setTextColor(getResources().getColor(R.color.steel));

        }else if (type.equals("dark") || type == "dark") {
            binding.txtPokemon.setTextColor(getResources().getColor(R.color.dark));
            binding.texthability1.setTextColor(getResources().getColor(R.color.dark));
            binding.texthability2.setTextColor(getResources().getColor(R.color.dark));
            binding.texttipoPokemon.setTextColor(getResources().getColor(R.color.dark));

        }else{
            //(type == "fairy"){
            binding.txtPokemon.setTextColor(getResources().getColor(R.color.fairy));
            binding.texthability1.setTextColor(getResources().getColor(R.color.fairy));
            binding.texthability2.setTextColor(getResources().getColor(R.color.fairy));
            binding.texttipoPokemon.setTextColor(getResources().getColor(R.color.fairy));
        }

    }
}

