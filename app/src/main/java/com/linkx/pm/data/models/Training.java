package com.linkx.pm.data.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

/**
 * Created by ulyx.yang@yeahmobi.com on 2016/8/31.
 */
@AutoValue
public abstract class Training extends Model {
    @JsonProperty("evYield")
    public abstract String evYield();

    @JsonProperty("catchRate")
    public abstract float catchRate();

    @JsonProperty("catchRateComment")
    public abstract String catchRateComment();

    @JsonProperty("baseHappiness")
    public abstract int baseHappiness();

    @JsonProperty("baseExp")
    public abstract int baseExp();

    @JsonProperty("growthRate")
    public abstract String growthRate();

    @JsonCreator
    public static Training create(@JsonProperty("evYield") String evYield,
                                  @JsonProperty("catchRate") float catchRate,
                                  @JsonProperty("catchRateComment") String catchRateComment,
                                  @JsonProperty("baseHappiness") int baseHappiness,
                                  @JsonProperty("baseExp") int baseExp,
                                  @JsonProperty("growthRate") String growthRate) {
        return new AutoValue_Training(evYield, catchRate, catchRateComment, baseHappiness, baseExp, growthRate);
    }

    public static Training dummy() {
        return new AutoValue_Training("1 Attack, 1 Special Attack", 0.45f,
            "5.9% with PokeBall,full HP", 70, 204, "Medium Slow");
    }


}
