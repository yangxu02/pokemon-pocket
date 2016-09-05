package com.linkx.pm.view.components;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.google.common.base.CaseFormat;
import com.linkx.pm.R;

public class DefenseUnitView extends FrameLayout {
    @Bind(R.id.defense_type)
    TextView defenseTypeText;
    @Bind(R.id.defense_effect)
    TextView defenseEffectText;

    public DefenseUnitView(Context context) {
        super(context);
        setup();
    }

    public DefenseUnitView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public DefenseUnitView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();
    }

    public DefenseUnitView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setup();
    }

    private void setup() {
        inflate(getContext(), R.layout.view_defense_unit, this);
        ButterKnife.bind(this);
    }

    public DefenseUnitView setup(String defense, int colorResource, String effect) {
        Log.w("POKE", "defense=" + defense + ",color=" + colorResource);
        defenseTypeText.setText(CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, defense));
        defenseTypeText.setBackgroundColor(getResources().getColor(colorResource));
        defenseEffectText.setText(effect);
        return this;
    }
}
