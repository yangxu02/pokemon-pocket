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
import com.linkx.pm.data.models.Training;

public class TrainingView extends FrameLayout {
    @Bind(R.id.training_container)
    LinearLayout trainingContainer;

    public TrainingView(Context context) {
        super(context);
        setup();
    }

    public TrainingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public TrainingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();
    }

    private void setup() {
        inflate(getContext(), R.layout.view_training, this);
        ButterKnife.bind(this);
    }

    private String toPercent(float value) {
        NumberFormat format = DecimalFormat.getPercentInstance();
        format.setMaximumFractionDigits(2);
        return format.format(value);
    }

    public void setTrainingAttr(PokemonDetail pokemonDetail) {
        Training training = pokemonDetail.training();
        Context context = getContext();
        trainingContainer.addView(new AttrView(context).setup("EvYield", training.evYield()));
        String catchRate = toPercent(training.catchRate()) + "(" + training.catchRateComment() + ")";
        trainingContainer.addView(new AttrView(context).setup("CatchRate", catchRate));
        trainingContainer.addView(new AttrView(context).setup("BaseHappiness", "" + training.baseHappiness()));
        trainingContainer.addView(new AttrView(context).setup("BaseExp", "" + training.baseExp()));
        trainingContainer.addView(new AttrView(context).setup("GrowthRate", "" + training.growthRate()));
    }
}
