package bhavin.movie.data.local;

import bhavin.movie.data.DataRepository;
import bhavin.movie.model.MovieDetailResponse;
import bhavin.movie.model.MoviesListResponse;
import io.reactivex.Maybe;

public class LocalRepository extends DataRepository {

    @Override
    public Maybe<MoviesListResponse> getMoviesList(String page) {
        return null;
    }

    @Override
    public Maybe<MovieDetailResponse> getMovieDetail(String movieId) {
        return null;
    }
}
