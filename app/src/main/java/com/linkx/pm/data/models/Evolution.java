package com.linkx.pm.data.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

/**
 * Created by ulyx.yang@yeahmobi.com on 2016/8/31.
 */
@AutoValue
public abstract class Evolution extends Model {
    @JsonProperty("upstreams")
    public abstract int[] upstreams();

    @JsonProperty("downstreams")
    public abstract int[] downstreams();

    @JsonCreator
    public static Evolution create(@JsonProperty("upstreams") int[] upstreams,
                                   @JsonProperty("downstreams") int[] downstreams) {
        return new AutoValue_Evolution(upstreams, downstreams);
    }

    public static Evolution dummy() {
        return new AutoValue_Evolution(new int[]{1}, new int[]{3});
    }


}
