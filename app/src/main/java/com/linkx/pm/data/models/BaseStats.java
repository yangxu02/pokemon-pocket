package com.linkx.pm.data.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

/**
 * Created by ulyx.yang@yeahmobi.com on 2016/8/31.
 */
@AutoValue
public abstract class BaseStats extends Model {

    @JsonProperty("normal")
    public abstract StatsDetail normal();

    @JsonProperty("min")
    public abstract StatsDetail min();

    @JsonProperty("max")
    public abstract StatsDetail max();

    @JsonCreator
    public static BaseStats create(@JsonProperty("normal") StatsDetail normal,
                                   @JsonProperty("min") StatsDetail min,
                                   @JsonProperty("max") StatsDetail max) {
        return new AutoValue_BaseStats(normal, min, max);
    }

    public static BaseStats dummy() {
        return new AutoValue_BaseStats(StatsDetail.dummy(), StatsDetail.dummy(), StatsDetail.dummy());
    }


    @AutoValue
    public static abstract class StatsDetail extends Model {
        @JsonProperty("hp")
        public abstract int hp();

        @JsonProperty("attack")
        public abstract int attack();

        @JsonProperty("defense")
        public abstract int defense();

        @JsonProperty("spAttack")
        public abstract int spAttack();

        @JsonProperty("spDefense")
        public abstract int spDefense();

        @JsonProperty("speed")
        public abstract int speed();

        @JsonCreator
        public static StatsDetail create(@JsonProperty("hp") int hp,
                                         @JsonProperty("attack") int attack,
                                         @JsonProperty("defense") int defense,
                                         @JsonProperty("spAttack") int spAttack,
                                         @JsonProperty("spDefense") int spDefense,
                                         @JsonProperty("speed") int speed) {
            return new AutoValue_BaseStats_StatsDetail(hp, attack, defense, spAttack, spDefense, speed);
        }

        public static StatsDetail dummy() {
            return new AutoValue_BaseStats_StatsDetail(70, 110, 70, 115, 70, 90);
        }


    }
}
