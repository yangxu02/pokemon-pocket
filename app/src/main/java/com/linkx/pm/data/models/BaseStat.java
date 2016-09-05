package com.linkx.pm.data.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import com.linkx.pm.R;

/**
 * Created by ulyx.yang@yeahmobi.com on 2016/8/31.
 */
@AutoValue
public abstract class BaseStat extends Model {
    @JsonProperty("value")
    public abstract int value();

    @JsonProperty("icon")
    public abstract Icon icon();

    @JsonCreator
    public static BaseStat create(@JsonProperty("value") int value,
                                  @JsonProperty("icon") Icon icon) {
        return new AutoValue_BaseStat(value, icon);
    }

    public enum Icon {
        HP(R.drawable.input),
        ATTACK(R.drawable.input),
        DEFENSE(R.drawable.input),
        SP_ATTACK(R.drawable.input),
        SP_DEFENSE(R.drawable.input),
        SPEED(R.drawable.input);

        private int icon;

        public int icon() {
            return icon;
        }

        Icon(int icon) {
            this.icon = icon;
        }
    }

}
