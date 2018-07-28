package bhavin.movie.ui.movielist;

import bhavin.movie.model.MoviesListResponse;
import bhavin.movie.ui.base.IBaseView;

public interface MovieListContract {

    interface  IMovieListView extends IBaseView {

        void addListToMovieAdapter(MoviesListResponse moviesListResponse);

        void hideProgressDialog();
    }
    interface IMovieListPresenter{

        void getMovieListFromApi();
    }
    interface IMovieListService{

        interface IMovieServiceCallback {
            void onMovieListApiCallSuccess(MoviesListResponse moviesListResponse);
            void onMovieListApiCallFailure(Throwable e);
        }

        void callMovieListApi(int pageNo,IMovieServiceCallback listener);
    }
}
