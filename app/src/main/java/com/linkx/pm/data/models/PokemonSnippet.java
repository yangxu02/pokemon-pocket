package com.linkx.pm.data.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import java.util.List;

/**
 * Created by ulyx.yang@yeahmobi.com on 2016/8/23.
 */

@AutoValue
public abstract class PokemonSnippet extends Model {
    @JsonCreator
    public static PokemonSnippet create(@JsonProperty("id") int id,
                                        @JsonProperty("name") String name,
                                        @JsonProperty("type") List<String> type,
                                        @JsonProperty("stamina") int stamina,
                                        @JsonProperty("attack") int attack,
                                        @JsonProperty("defense") int defense,
                                        @JsonProperty("capture_rate") float captureRate,
                                        @JsonProperty("flee_rate") float fleeRate,
                                        @JsonProperty("candy") int candy,
                                        @JsonProperty("quick_moves") List<String> quickMoves,
                                        @JsonProperty("special_moves") List<String> specialMoves
    ) {
        return new AutoValue_PokemonSnippet(id, name, type, stamina, attack, defense,
                captureRate, fleeRate, candy, quickMoves, specialMoves);
    }

    /*
    ['#', 'Name', 'Type', 'Stamina', 'Attack', 'Defense', 'Capture Rate', 'Flee Rate', 'Candy', 'Quick Moves', 'Special Moves'] = [['151'], ['Mew'], ['Psychic'], ['200'], ['220'], ['220'], ['-'], ['10%'], ['-'], ['Pound'], ['Dragon Pulse', 'Earthquake', 'Fire Blast', 'Hurricane', 'Hyper Beam', 'Moonblast', 'Psychic', 'Solar Beam', 'Thunder']]
     */
    @JsonProperty("id")
    public abstract int id();

    @JsonProperty("name")
    public abstract String name();

    @JsonProperty("type")
    public abstract List<String> type();

    @JsonProperty("stamina")
    public abstract int stamina();

    @JsonProperty("attack")
    public abstract int attack();

    @JsonProperty("defense")
    public abstract int defense();

    @JsonProperty("capture_rate")
    public abstract float captureRate();

    @JsonProperty("flee_rate")
    public abstract float fleeRate();

    @JsonProperty("candy")
    public abstract int candy();

    @JsonProperty("quick_moves")
    public abstract List<String> quickMoves();

    @JsonProperty("special_moves")
    public abstract List<String> specialMoves();

}
