package com.linkx.pm.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.etsy.android.grid.StaggeredGridView;
import java.util.List;
import com.linkx.pm.R;
import com.linkx.pm.data.models.PokemonSnippet;
import com.linkx.pm.data.services.PokemonService;
import com.linkx.pm.data.services.SuggestionService;
import com.linkx.pm.view.adapters.PokemonListAdapter;
import com.linkx.pm.view.components.SearchView;
import rx.Subscription;
import rx.android.app.AppObservable;
import rx.subscriptions.Subscriptions;

public class MainActivity extends BaseActivity {

    //    @Bind(R.id.drawer_layout)
//    DrawerLayout drawerLayout;
//    @Bind(R.id.navigation_view)
//    NavigationView navigationView;
    @Bind(R.id.search_view)
    SearchView searchView;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.channel_pokemon_list)
    StaggeredGridView pokemonListView;

    private PokemonListAdapter pokemonListAdapter;
    private Subscription pokemonSubscription = Subscriptions.empty();
    private Subscription querySubscription = Subscriptions.empty();
    private Subscription suggestionsSubscription = Subscriptions.empty();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupActionBar();
        setupViews();
    }

    @Override
    protected void onDestroy() {
        pokemonSubscription.unsubscribe();
        querySubscription.unsubscribe();
        suggestionsSubscription.unsubscribe();
        super.onDestroy();
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    */

    private void setupActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        /*
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close);
        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();
        */
    }

    private void setupViews() {
//        navigationView.addHeaderView(new DrawerHeaderView(this));

        pokemonSubscription = AppObservable.bindActivity(this, new PokemonService(getApplicationComponent()).getSnippets())
                .subscribe(this::setupViews);
        querySubscription = AppObservable.bindActivity(this, searchView.observe())
                .subscribe(this::updateSuggestions);
    }

    private void updateSuggestions(String query) {
        suggestionsSubscription.unsubscribe();
        suggestionsSubscription = AppObservable.bindActivity(this, new SuggestionService(getApplicationComponent()).get(query))
                .subscribe(searchView::updateSuggestions);
    }

    private void setupViews(List<PokemonSnippet> pokemonSnippets) {
        LayoutInflater layoutInflater = getLayoutInflater();

        View header = layoutInflater.inflate(R.layout.list_header_channel_pokemon, null);

        pokemonListView.addHeaderView(header);

        pokemonListAdapter = new PokemonListAdapter(this, pokemonSnippets);
        pokemonListView.setAdapter(pokemonListAdapter);
    }
}
