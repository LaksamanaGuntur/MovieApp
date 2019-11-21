package co.id.movieapp.di.module;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import co.id.movieapp.CoreApp;
import co.id.movieapp.data.DaoMaster;
import co.id.movieapp.data.DaoSession;
import co.id.movieapp.di.scope.ActivityScope;
import co.id.movieapp.helper.Constant;
import co.id.movieapp.model.DataModel;
import co.id.movieapp.network.NetworkService;
import co.id.movieapp.repository.MainRepository;
import co.id.movieapp.ui.detail.DetailActivity;
import co.id.movieapp.ui.detail.DetailPresenter;
import co.id.movieapp.ui.main.MainActivity;
import co.id.movieapp.ui.main.MainPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Laksamana Guntur Dzulfikar.
 * Android Developer
 */

@Module
public class MainActivityModule {
    private MainActivity mainActivity;
    private DetailActivity detailActivity;

    public MainActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public MainActivityModule(DetailActivity detailActivity) {
        this.detailActivity = detailActivity;
    }

    @Provides
    @ActivityScope
    MainActivity provideMainActivity() {
        return mainActivity;
    }

    @Provides
    @ActivityScope
    MainRepository provideMainRepository(NetworkService networkService) {
        return new MainRepository(networkService);
    }

    @Provides
    @ActivityScope
    DaoSession provideDaoSession() {
        String DbName = Constant.DATABASE_NAME;
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(CoreApp.get(), DbName);
        Log.d("New DB Name: ", DbName);
        SQLiteDatabase db = devOpenHelper.getWritableDatabase();
        Log.d("DB PATH", db.getPath());
        DaoMaster daoMaster = new DaoMaster(db);
        return daoMaster.newSession();
    }


    @Provides
    @ActivityScope
    DataModel provideDataModel(DaoSession daoSession){
        return new DataModel(daoSession);
    }

    @Provides
    @ActivityScope
    MainPresenter provideMainPresenter(MainRepository mainRepository, DataModel dataModel) {
        return new MainPresenter(mainRepository, dataModel);
    }

    @Provides
    @ActivityScope
    DetailPresenter provideDetailPresenter(DataModel dataModel) {
        return new DetailPresenter(dataModel);
    }
}
