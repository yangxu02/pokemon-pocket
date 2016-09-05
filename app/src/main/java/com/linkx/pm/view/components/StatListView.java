package com.linkx.pm.view.components;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.linkx.pm.R;
import com.linkx.pm.data.models.BaseStat;
import com.linkx.pm.data.models.BaseStats;
import com.linkx.pm.data.models.PokemonDetail;

public class StatListView extends FrameLayout {
    @Bind(R.id.stats_container)
    LinearLayout statsContainer;

    public StatListView(Context context) {
        super(context);
        setup();
    }

    public StatListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public StatListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();
    }

    private void setup() {
        inflate(getContext(), R.layout.view_stat_list, this);
        ButterKnife.bind(this);
    }

    public void setStats(PokemonDetail pokemonDetail) {
        BaseStats.StatsDetail normal = pokemonDetail.stats().normal();
        Context context = getContext();
        statsContainer.addView(new StatView(context).setup(BaseStat.create(normal.hp(), BaseStat.Icon.HP)));
        statsContainer.addView(new StatView(context).setup(BaseStat.create(normal.attack(), BaseStat.Icon.ATTACK)));
        statsContainer.addView(new StatView(context).setup(BaseStat.create(normal.defense(), BaseStat.Icon.DEFENSE)));
        statsContainer.addView(new StatView(context).setup(BaseStat.create(normal.spAttack(), BaseStat.Icon.SP_ATTACK)));
        statsContainer.addView(new StatView(context).setup(BaseStat.create(normal.spDefense(), BaseStat.Icon.SP_DEFENSE)));
        statsContainer.addView(new StatView(context).setup(BaseStat.create(normal.speed(), BaseStat.Icon.SPEED)));
    }
}
