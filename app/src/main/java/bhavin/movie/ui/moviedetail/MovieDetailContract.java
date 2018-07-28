package bhavin.movie.ui.moviedetail;

import bhavin.movie.model.MovieDetailResponse;
import bhavin.movie.ui.base.IBaseView;

public interface MovieDetailContract {
    interface IMovieDetailView extends IBaseView {

        void setMovieDetailToViews(MovieDetailResponse movieDetailResponse);
    }
    interface IMovieDetailPresenter{

        void setMovieId(String stringExtra);

        void callMovieDetailApi();
    }
    interface IMovieDetailService{
        void callMovieDetailsApi(String movieId, IMovieDetailServiceCallback listener);

        interface IMovieDetailServiceCallback{

            void onMovieDetailApiCallError(Throwable e);

            void onMovieDetailApiCallSuccess(MovieDetailResponse movieDetailResponse);
        }
    }
}
