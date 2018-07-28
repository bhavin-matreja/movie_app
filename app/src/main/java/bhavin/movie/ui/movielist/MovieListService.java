package bhavin.movie.ui.movielist;

import bhavin.movie.domain.AppUseCase;
import bhavin.movie.model.MoviesListResponse;
import io.reactivex.observers.DisposableMaybeObserver;

public class MovieListService implements MovieListContract.IMovieListService {

    private AppUseCase useCase = new AppUseCase();

    @Override
    public void callMovieListApi(int pageNo, IMovieServiceCallback listener) {
        useCase.getMoviesList(String.valueOf(pageNo)).subscribe(new MovieListObserver(listener));
    }

    private class MovieListObserver extends DisposableMaybeObserver<MoviesListResponse>{

        private IMovieServiceCallback listener;

        public MovieListObserver(IMovieServiceCallback listener) {
            this.listener = listener;
        }

        @Override
        public void onSuccess(MoviesListResponse moviesListResponse) {
            listener.onMovieListApiCallSuccess(moviesListResponse);
        }

        @Override
        public void onError(Throwable e) {
            listener.onMovieListApiCallFailure(e);
        }

        @Override
        public void onComplete() {

        }
    }
}
