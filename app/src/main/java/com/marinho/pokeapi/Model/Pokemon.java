package com.marinho.pokeapi.Model;

import java.util.List;

public class Pokemon {

    private com.marinho.pokeapi.Model.sprites sprites;
    private String name;


    public List<com.marinho.pokeapi.Model.abilities> abilities ;

    public List<com.marinho.pokeapi.Model.types> types;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public com.marinho.pokeapi.Model.sprites getSprites() {
        return sprites;
    }

    public void setSprites(com.marinho.pokeapi.Model.sprites sprites) {
        this.sprites = sprites;
    }
}






