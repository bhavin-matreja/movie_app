package bhavin.movie.ui.moviedetail;

import bhavin.movie.model.MovieDetailResponse;

public class MovieDetailPresenter implements MovieDetailContract.IMovieDetailPresenter,
        MovieDetailContract.IMovieDetailService.IMovieDetailServiceCallback {

    private MovieDetailContract.IMovieDetailView view;
    private MovieDetailContract.IMovieDetailService service;
    private String movieId;

    public MovieDetailPresenter(MovieDetailContract.IMovieDetailView view, MovieDetailContract.IMovieDetailService service) {
        this.view = view;
        this.service = service;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    @Override
    public void callMovieDetailApi() {
        service.callMovieDetailsApi(movieId,this);
    }

    @Override
    public void onMovieDetailApiCallError(Throwable e) {
        e.printStackTrace();
        view.showToastMessage(e.getMessage());
    }

    @Override
    public void onMovieDetailApiCallSuccess(MovieDetailResponse movieDetailResponse) {
        view.setMovieDetailToViews(movieDetailResponse);
    }
}
