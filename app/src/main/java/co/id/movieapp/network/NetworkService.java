package co.id.movieapp.network;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Laksamana Guntur Dzulfikar.
 * Android Developer
 */

public interface NetworkService {
    @GET("movie/popular")
    Flowable<ApiResponse> getData(@Query("api_key") String api_key);

}
