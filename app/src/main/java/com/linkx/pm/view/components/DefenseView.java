package com.linkx.pm.view.components;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import butterknife.Bind;
import butterknife.ButterKnife;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;
import com.linkx.pm.R;
import com.linkx.pm.data.models.PokemonDetail;
import com.linkx.pm.data.models.PokemonType;
import com.linkx.pm.data.models.TypeDefense;

public class DefenseView extends FrameLayout {

    @Bind(R.id.defense_grid_view)
    GridLayout defenseGridView;

    public DefenseView(Context context) {
        super(context);
        setup();
    }

    public DefenseView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public DefenseView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();
    }

    private void setup() {
        inflate(getContext(), R.layout.view_defense_grid, this);
        ButterKnife.bind(this);
    }

    private String toPercent(float value) {
        NumberFormat format = DecimalFormat.getPercentInstance();
        format.setMaximumFractionDigits(0);
        return format.format(value);
    }


    public void setDefenseGrid(PokemonDetail pokemonDetail) {
        Context context = getContext();
        TypeDefense defenses = pokemonDetail.defense();

        for (Map.Entry<PokemonType, Float> defense : defenses.effects().entrySet()) {
            PokemonType defenseType = defense.getKey();
            float defenseValue = defense.getValue();
            DefenseUnitView view = new DefenseUnitView(context).setup(defenseType.name(), defenseType.color(), toPercent(defenseValue));
            defenseGridView.addView(view);
        }
    }
}
