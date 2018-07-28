package bhavin.movie.ui.moviedetail;

import bhavin.movie.domain.AppUseCase;
import bhavin.movie.model.MovieDetailResponse;
import bhavin.movie.model.MoviesListResponse;
import io.reactivex.MaybeObserver;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableMaybeObserver;

public class MovieDetailService implements MovieDetailContract.IMovieDetailService {

    private AppUseCase appUseCase = new AppUseCase();;

    @Override
    public void callMovieDetailsApi(String movieId, MovieDetailContract.IMovieDetailService.IMovieDetailServiceCallback listener) {
        appUseCase.getMoviesDetail(movieId).subscribe(new MovieDetailObserver(listener));
    }

    private class MovieDetailObserver extends DisposableMaybeObserver<MovieDetailResponse> {

        private IMovieDetailServiceCallback listener;

        public MovieDetailObserver(IMovieDetailServiceCallback listener) {

            this.listener = listener;
        }

        @Override
        public void onSuccess(MovieDetailResponse movieDetailResponse) {
            listener.onMovieDetailApiCallSuccess(movieDetailResponse);
        }

        @Override
        public void onError(Throwable e) {
            listener.onMovieDetailApiCallError(e);
        }

        @Override
        public void onComplete() {

        }
    }
}
