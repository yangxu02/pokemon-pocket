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
public abstract class Breeding extends Model {
    @JsonCreator
    public static Breeding create(@JsonProperty("eggGroups") List<String> eggGroups,
                                  @JsonProperty("chanceMale") float chanceMale,
                                  @JsonProperty("chanceFemale") float chanceFemale,
                                  @JsonProperty("eggCycles") int eggCycles,
                                  @JsonProperty("eggCyclesComment") String eggCyclesComment) {
        return new AutoValue_Breeding(eggGroups, chanceMale, chanceFemale, eggCycles, eggCyclesComment);
    }

    public static Breeding dummy() {
        return new AutoValue_Breeding(Lists.newArrayList("Field", "Human-Like"),
                0.875f, 0.125f, 26, "minimum 6630 steps");
    }

    @JsonProperty("eggGroups")
    public abstract List<String> eggGroups();

    @JsonProperty("chanceMale")
    public abstract float chanceMale();

    @JsonProperty("chanceFemale")
    public abstract float chanceFemale();

    @JsonProperty("eggCycles")
    public abstract int eggCycles();

    @JsonProperty("eggCyclesComment")
    public abstract String eggCyclesComment();


}
