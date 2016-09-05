package com.linkx.pm.data.services;

import java.util.List;
import com.linkx.pm.data.models.PokemonDetail;
import com.linkx.pm.data.models.PokemonSnippet;
import com.linkx.pm.data.models.Pokemons;
import com.linkx.pm.di.components.ApplicationComponent;
import rx.Observable;
import rx.schedulers.Schedulers;

public class PokemonService extends BaseService {

    public PokemonService(ApplicationComponent applicationComponent) {
        super(applicationComponent);
    }

    public Observable<List<PokemonSnippet>> getSnippets() {
        return makeObservable(Pokemons.allPokemons(applicationComponent.context())).subscribeOn(Schedulers.computation());
    }

    public Observable<PokemonDetail> getDetail(String name) {
        return makeObservable(Pokemons.pokemonDetail(applicationComponent.context(), name)).subscribeOn(Schedulers.computation());
    }

    public Observable<PokemonDetail> getDetail(PokemonSnippet snippet) {
        return makeObservable(Pokemons.pokemonDetail(applicationComponent.context(), snippet)).subscribeOn(Schedulers.computation());
    }


}
