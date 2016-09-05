package com.linkx.pm.data.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

/**
 * Created by ulyx.yang@yeahmobi.com on 2016/8/31.
 */
@AutoValue
public abstract class DefenseUnit extends Model {

    @JsonCreator
    public static DefenseUnit create(@JsonProperty("type") PokemonType type,
                                     @JsonProperty("effect") float effect) {
        return new AutoValue_DefenseUnit(type, effect);
    }

    @JsonProperty("type")
    public abstract PokemonType type();

    @JsonProperty("effect")
    public abstract float effect();

}
