package co.id.movieapp.di.component;

import javax.inject.Singleton;

import co.id.movieapp.di.module.AppModule;
import co.id.movieapp.di.module.NetworkModule;
import co.id.movieapp.di.module.MainActivityModule;
import dagger.Component;

/**
 * Created by Laksamana Guntur Dzulfikar.
 * Android Developer
 */

@Singleton
@Component(
        modules = {
                AppModule.class,
                NetworkModule.class
        }
)

public interface AppComponent {
    MainComponent plus(MainActivityModule mainActivityModule);
}
