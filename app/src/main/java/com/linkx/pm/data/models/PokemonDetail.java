package com.linkx.pm.data.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

/**
 * Created by ulyx.yang@yeahmobi.com on 2016/8/31.
 */
@AutoValue
public abstract class PokemonDetail extends Model {

    @JsonProperty("snippet")
    public abstract PokemonSnippet snippet();

    @JsonProperty("stats")
    public abstract BaseStats stats();

    @JsonProperty("breeding")
    public abstract Breeding breeding();

    @JsonProperty("dex")
    public abstract PokeDex dex();

    @JsonProperty("training")
    public abstract Training training();

    @JsonProperty("defense")
    public abstract TypeDefense defense();

    @JsonProperty("nameOrigin")
    public abstract NameOrigin nameOrigin();

    @JsonProperty("evolution")
    public abstract Evolution evolution();

    @JsonCreator
    public static PokemonDetail create(@JsonProperty("snippet") PokemonSnippet snippet,
                                       @JsonProperty("stats") BaseStats stats,
                                       @JsonProperty("breeding") Breeding breeding,
                                       @JsonProperty("dex") PokeDex dex,
                                       @JsonProperty("training") Training training,
                                       @JsonProperty("defense") TypeDefense defense,
                                       @JsonProperty("nameOrigin") NameOrigin nameOrigin,
                                       @JsonProperty("evolution") Evolution evolution) {
        return new AutoValue_PokemonDetail(snippet, stats, breeding, dex, training, defense, nameOrigin, evolution);
    }

    public static PokemonDetail dummy(PokemonSnippet snippet) {
        return new AutoValue_PokemonDetail(snippet, BaseStats.dummy(), Breeding.dummy(),
            PokeDex.dummy(), Training.dummy(), TypeDefense.dummy(), NameOrigin.dummy(),
            Evolution.dummy()
        );
    }


}
