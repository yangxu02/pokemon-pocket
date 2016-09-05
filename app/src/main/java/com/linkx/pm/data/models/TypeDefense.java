package com.linkx.pm.data.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by ulyx.yang@yeahmobi.com on 2016/8/31.
 */
@AutoValue
public abstract class TypeDefense extends Model {

    @JsonCreator
    public static TypeDefense create(@JsonProperty("effects") Map<PokemonType, Float> effects) {
        return new AutoValue_TypeDefense(effects);
    }

    public static TypeDefense dummy() {
        ImmutableMap.Builder<PokemonType, Float> builder
            = new ImmutableMap.Builder<PokemonType, Float>();
        Random random = new Random();
        for (PokemonType type : PokemonType.values()) {
            builder.put(type, (float) (1.0 * random.nextInt(100) / 100));
        }

        return new AutoValue_TypeDefense(builder.build());
    }

    @JsonProperty("effects")
    public abstract Map<PokemonType, Float> effects();


}
