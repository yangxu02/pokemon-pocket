package com.linkx.pm.view.components;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.google.common.base.CaseFormat;
import com.linkx.pm.R;
import com.linkx.pm.data.models.BaseStat;

public class StatView extends FrameLayout {
    @Bind(R.id.stat_bar)
    ProgressBar statBar;
    @Bind(R.id.stat_name)
    TextView statNameText;
    @Bind(R.id.stat_value)
    TextView statValue;


    public StatView(Context context) {
        super(context);
        setup();
    }

    public StatView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public StatView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();
    }

    public StatView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setup();
    }

    private void setup() {
        inflate(getContext(), R.layout.view_stat, this);
        ButterKnife.bind(this);
    }

    public StatView setup(BaseStat stat) {
//        Picasso.with(getContext())
//            .load(stat.icon().icon()).into(statIcon);
        statBar.setProgress(stat.value());
        // TODO
        statBar.setMax(150);
        String name = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, stat.icon().name());
        statNameText.setText(name);
        statValue.setText("" + stat.value());
        return this;
    }
}
