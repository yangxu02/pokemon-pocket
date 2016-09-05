package com.linkx.pm.data.services;

import java.util.List;
import com.linkx.pm.data.models.Pokemons;
import com.linkx.pm.di.components.ApplicationComponent;
import rx.Observable;
import rx.schedulers.Schedulers;

public class SuggestionService extends BaseService {

    public SuggestionService(ApplicationComponent applicationComponent) {
        super(applicationComponent);
    }

    public Observable<List<String>> get(String query) {

        return makeObservable(Pokemons.allPokemonNames(applicationComponent.context(), query)).subscribeOn(Schedulers.computation());

    }
}
