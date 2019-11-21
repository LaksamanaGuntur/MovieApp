package co.id.movieapp.repository;

import co.id.movieapp.helper.Constant;
import co.id.movieapp.network.ApiResponse;
import co.id.movieapp.network.NetworkService;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Laksamana Guntur Dzulfikar.
 * Android Developer
 */

public class MainRepository extends BaseRepository {
    public MainRepository(NetworkService networkService) {
        super(networkService);
    }

    /**
     * Get Data
     * @Param Sorting Type
     * */
    public Flowable<ApiResponse> getData() {
        return networkService.getData(Constant.API_KEY)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
