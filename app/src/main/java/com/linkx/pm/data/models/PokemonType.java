package com.linkx.pm.data.models;

import com.linkx.pm.R;

/**
 * Created by ulyx.yang@yeahmobi.com on 2016/8/31.
 */
public enum PokemonType {
    normal(R.color.gray),
    fire(R.color.red),
    water(R.color.blue),
    electric(R.color.lightgray),
    grass(R.color.green),
    ice(R.color.white),
    fighting(R.color.red),
    poison(R.color.deep_orange),
    ground(R.color.green_teal),
    flying(R.color.blue),
    psychic(R.color.purple),
    bug(R.color.yellow),
    rock(R.color.rock),
    ghost(R.color.black),
    dragon(R.color.dragon),
    dark(R.color.dark),
    steel(R.color.steel),
    fairy(R.color.fairy);

    private final int color;

    PokemonType(int color) {
        this.color = color;
    }

    public int color() {
        return color;
    }
}
