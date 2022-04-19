package com.marinho.pokeapi.Model;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class imagensAPI {

    public static void picasso(ImageView imgView, String imgUrl) {
        Picasso.get()
                .load(imgUrl)
                .resize(200, 200)
                .centerCrop()
                .into(imgView);
    }
}
