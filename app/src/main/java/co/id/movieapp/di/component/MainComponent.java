package co.id.movieapp.di.component;

import co.id.movieapp.di.scope.ActivityScope;
import co.id.movieapp.di.module.MainActivityModule;
import co.id.movieapp.ui.detail.DetailActivity;
import co.id.movieapp.ui.main.MainActivity;
import dagger.Subcomponent;

/**
 * Created by Laksamana Guntur Dzulfikar.
 * Android Developer
 */

@ActivityScope
@Subcomponent(
        modules = MainActivityModule.class
)
public interface MainComponent {
    MainActivity inject(MainActivity mainActivity);
    DetailActivity inject(DetailActivity detailActivity);
}
