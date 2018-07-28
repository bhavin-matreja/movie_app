package bhavin.movie.domain;

import bhavin.movie.data.DataRepository;
import bhavin.movie.data.local.LocalRepository;
import bhavin.movie.data.remote.RemoteRepository;
import bhavin.movie.data.remote.RetrofitFactory;
import bhavin.movie.model.MovieDetailResponse;
import bhavin.movie.model.MoviesListResponse;
import bhavin.movie.util.NetworkHelper;
import io.reactivex.Maybe;

public class AppUseCase {
    private RemoteRepository remoteRepository;
    private NetworkHelper networkHelper;
    private LocalRepository localRepository;

    public AppUseCase() {
        this.remoteRepository = new RemoteRepository(RetrofitFactory.getAdapter());
        this.localRepository = new LocalRepository();
        this.networkHelper = NetworkHelper.getInstance();
    }

    public Maybe<MoviesListResponse> getMoviesList(String pageNo){
        if (networkHelper.isNetworkAvailable()) {
            return remoteRepository.getMoviesList(pageNo);
        }
        else {
            // Call from local repo instead
           // return localRepository.getMoviesList(pageNo);
        }
        return null;
    }

    public Maybe<MovieDetailResponse> getMoviesDetail(String movieId){
        if (networkHelper.isNetworkAvailable()) {
            return remoteRepository.getMovieDetail(movieId);
        }
        else {
            //return localRepository.getMovieDetail(movieId);
        }
        return null;
    }
}
