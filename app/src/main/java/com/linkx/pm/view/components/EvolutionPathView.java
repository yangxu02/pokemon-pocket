package com.linkx.pm.view.components;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import butterknife.Bind;
import butterknife.ButterKnife;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import com.linkx.pm.R;
import com.linkx.pm.data.models.PokemonDetail;

public class EvolutionPathView extends FrameLayout {
    @Bind(R.id.evolution_stage_container)
    LinearLayout evolutionStageContainer;

    public EvolutionPathView(Context context) {
        super(context);
        setup();
    }

    public EvolutionPathView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public EvolutionPathView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();
    }

    private void setup() {
        inflate(getContext(), R.layout.view_evolution_path, this);
        ButterKnife.bind(this);
    }

    private String toPercent(float value) {
        NumberFormat format = DecimalFormat.getPercentInstance();
        format.setMaximumFractionDigits(2);
        return format.format(value);
    }

    public void setEvolutionPath(PokemonDetail pokemonDetail) {
        Context context = getContext();
        evolutionStageContainer.addView(new EvolutionView(context).setEvolutionStage(pokemonDetail));
    }
}
