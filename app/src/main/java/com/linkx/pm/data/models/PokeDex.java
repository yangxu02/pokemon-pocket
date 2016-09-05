package com.linkx.pm.data.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import com.google.common.collect.Lists;
import java.util.List;

/**
 * Created by ulyx.yang@yeahmobi.com on 2016/8/31.
 */
@AutoValue
public abstract class PokeDex extends Model {
    @JsonCreator
    public static PokeDex create(@JsonProperty("national") int national,
                                 @JsonProperty("type") List<PokemonType> type,
                                 @JsonProperty("species") String species,
                                 @JsonProperty("height") float height,
                                 @JsonProperty("weight") float weight,
                                 @JsonProperty("abilities") List<PokemonAbility> abilities,
                                 @JsonProperty("locals") int[] locals,
                                 @JsonProperty("aliasInJapanese") String aliasInJapanese) {
        return new AutoValue_PokeDex(national, type, species, height, weight, abilities, locals, aliasInJapanese);
    }

    public static PokeDex dummy() {
        return new AutoValue_PokeDex(448,
                Lists.newArrayList(PokemonType.fighting, PokemonType.steel),
                "Aura Pokemon", 1.19f, 54.0f,
                Lists.newArrayList(PokemonAbility.create("Inner Focus", "", 0),
                        PokemonAbility.create("Steadfast", "", 0),
                        PokemonAbility.create("Justified", "", 0)
                ), new int[]{116, 116, 034, 063}, "Rukario");
    }

    @JsonProperty("national")
    public abstract int national();

    @JsonProperty("type")
    public abstract List<PokemonType> type();

    @JsonProperty("species")
    public abstract String species();

    @JsonProperty("height")
    public abstract float height(); // m

    @JsonProperty("weight")
    public abstract float weight(); // kg

    @JsonProperty("abilities")
    public abstract List<PokemonAbility> abilities();

    @JsonProperty("locals")
    public abstract int[] locals();

    @JsonProperty("aliasInJapanese")
    public abstract String aliasInJapanese();


}
