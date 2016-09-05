package com.linkx.pm.data.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

/**
 * Created by ulyx.yang@yeahmobi.com on 2016/8/31.
 */
@AutoValue
public abstract class PokemonAbility extends Model {
    @JsonProperty("name")
    public abstract String name();

    @JsonProperty("desc")
    public abstract String desc();

    @JsonProperty("generation")
    public abstract int generation();

    @JsonCreator
    public static PokemonAbility create(@JsonProperty("name") String name,
                                        @JsonProperty("desc") String desc,
                                        @JsonProperty("generation") int generation) {
        return new AutoValue_PokemonAbility(name, desc, generation);
    }


}
