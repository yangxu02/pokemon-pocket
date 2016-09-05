package com.linkx.pm.data.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

/**
 * Created by ulyx.yang@yeahmobi.com on 2016/8/31.
 */
@AutoValue
public abstract class NameOrigin extends Model {
    @JsonProperty("source")
    public abstract String source();

    @JsonProperty("explain")
    public abstract String explain();

    @JsonCreator
    public static NameOrigin create(@JsonProperty("source") String source,
                                    @JsonProperty("explain") String explain) {
        return new AutoValue_NameOrigin(source, explain);
    }

    public static NameOrigin dummy() {
        return new AutoValue_NameOrigin("source", "explain");
    }

}
