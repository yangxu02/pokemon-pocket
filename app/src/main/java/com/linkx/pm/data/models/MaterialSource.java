package com.linkx.pm.data.models;

/**
 * Created by ulyx.yang@yeahmobi.com on 2016/8/29.
 */
public class MaterialSource {

    public static class PokemonWrapper {

        private final static String imgRepo
            = "https://img.pokemondb.net/artwork/";
        private final static String iconRepo
            = "https://img.pokemondb.net/sprites/black-white/normal/";

        public static String imageUrl(PokemonSnippet pokemonSnippet) {
            return imgRepo + pokemonSnippet.name().toLowerCase() + ".jpg";
        }

        public static String iconUrl(PokemonSnippet pokemonSnippet) {
            return iconRepo + pokemonSnippet.name().toLowerCase() + ".png";
        }
    }

}
