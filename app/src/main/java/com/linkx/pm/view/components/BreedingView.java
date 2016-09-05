package com.linkx.pm.view.components;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import butterknife.Bind;
import butterknife.ButterKnife;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import com.linkx.pm.R;
import com.linkx.pm.data.models.Breeding;
import com.linkx.pm.data.models.PokemonDetail;

public class BreedingView extends FrameLayout {
    @Bind(R.id.breeding_container)
    LinearLayout breedingContainer;

    public BreedingView(Context context) {
        super(context);
        setup();
    }

    public BreedingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public BreedingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();
    }

    private void setup() {
        inflate(getContext(), R.layout.view_breeding, this);
        ButterKnife.bind(this);
    }

    private String toPercent(float value) {
        NumberFormat format = DecimalFormat.getPercentInstance();
        format.setMaximumFractionDigits(2);
        return format.format(value);
    }

    public void setBreedingAttr(PokemonDetail pokemonDetail) {
        Breeding breeding = pokemonDetail.breeding();
        Context context = getContext();
        String eggGroups = TextUtils.join(", ", breeding.eggGroups());
        breedingContainer.addView(new AttrView(context).setup("EggGroups", eggGroups));
        String gender = "Male " + toPercent(breeding.chanceMale()) + ", Female " + toPercent(breeding.chanceFemale());
        breedingContainer.addView(new AttrView(context).setup("Gender", gender));
        String eggCycles = breeding.eggCycles() + "(" + breeding.eggCyclesComment() + ")";
        breedingContainer.addView(new AttrView(context).setup("EggCycles", eggCycles));
    }
}
