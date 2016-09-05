package com.linkx.pm.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.squareup.picasso.Picasso;
import com.linkx.pm.R;
import com.linkx.pm.data.models.MaterialSource;
import com.linkx.pm.data.models.Model;
import com.linkx.pm.data.models.PokemonDetail;
import com.linkx.pm.data.models.PokemonSnippet;
import com.linkx.pm.data.services.PokemonService;
import com.linkx.pm.view.Transition;
import com.linkx.pm.view.components.BreedingView;
import com.linkx.pm.view.components.DefenseView;
import com.linkx.pm.view.components.DexView;
import com.linkx.pm.view.components.EvolutionPathView;
import com.linkx.pm.view.components.StatListView;
import com.linkx.pm.view.components.TrainingView;
import rx.Subscription;
import rx.android.app.AppObservable;
import rx.subscriptions.Subscriptions;

public class PokemonProfileActivity extends BaseActivity {
    public static final String EXTRA_POKEMON = "pokemonSnippet";

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.pokemon_icon)
    ImageView pokemonIcon;
    @Bind(R.id.base_stats)
    StatListView baseStatsView;
    @Bind(R.id.training_view)
    TrainingView trainingView;
    @Bind(R.id.breeding_view)
    BreedingView breedingView;
    @Bind(R.id.evolution_view)
    EvolutionPathView evolutionView;
    @Bind(R.id.dex_view)
    DexView dexView;
    @Bind(R.id.defense_view)
    DefenseView defenseView;
    @Bind(R.id.defense_card)
    CardView defenseCard;

    // TODO
    private Subscription pokemonSubscription = Subscriptions.empty();

    public static void launch(Activity activity, PokemonSnippet pokemonSnippet, Transition transition) {
        Intent intent = new Intent(activity, PokemonProfileActivity.class);
        intent.putExtra(EXTRA_POKEMON, pokemonSnippet.toJson());
        Transition.putTransition(intent, transition);
        activity.startActivity(intent);
        transition.overrideOpenTransition(activity);
    }

    @Override
    public void finish() {
        super.finish();
        Transition.getTransition(getIntent()).overrideCloseTransition(this);
    }

    @Override
    protected void onDestroy() {
        pokemonSubscription.unsubscribe();
        super.onDestroy();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_profile_allinone);
        ButterKnife.bind(this);
        setupActionBar();
        PokemonSnippet snippet = Model.fromJson(getIntent().getStringExtra(EXTRA_POKEMON), PokemonSnippet.class);
        setupViews(snippet);
    }

    private void setupActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
    }

    private void setupViews(PokemonSnippet snippet) {
        pokemonSubscription = AppObservable.bindActivity(this, new PokemonService(getApplicationComponent()).getDetail(snippet))
                .subscribe(this::setupViews);
    }

    private void setupViews(PokemonDetail pokemonDetail) {
        Picasso.with(this).load(MaterialSource.PokemonWrapper.iconUrl(pokemonDetail.snippet()))
//                .resize(256, 256)
                .fit()
                .into(pokemonIcon);
        baseStatsView.setStats(pokemonDetail);
        breedingView.setBreedingAttr(pokemonDetail);
        trainingView.setTrainingAttr(pokemonDetail);
        evolutionView.setEvolutionPath(pokemonDetail);
        dexView.setDexAttr(pokemonDetail);
        defenseView.setDefenseGrid(pokemonDetail);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
