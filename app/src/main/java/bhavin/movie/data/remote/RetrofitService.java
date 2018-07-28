package bhavin.movie.data.remote;

import bhavin.movie.model.MovieDetailResponse;
import bhavin.movie.model.MoviesListResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 * Created by Bhavin on 4/9/2018.
 */

public interface RetrofitService {

       @POST("now_playing/")
       Single<MoviesListResponse> getMovieList(@Query("api_key") String apiKey,@Query("page") String page);

       @GET("{movieId}")
       Single<MovieDetailResponse> getMovieDetail(@Path("movieId") String movieId, @Query("api_key") String apikey);
}
