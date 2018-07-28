package bhavin.movie.ui.movielist;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.annotation.Annotation;

import bhavin.movie.model.MoviesListResponse;
import bhavin.movie.util.Utility;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.HttpException;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieListPresenter implements MovieListContract.IMovieListPresenter,MovieListContract.IMovieListService.IMovieServiceCallback {

    private MovieListContract.IMovieListView view;
    private MovieListContract.IMovieListService service;
    private int pageNo=1;

    public MovieListPresenter(MovieListContract.IMovieListView view, MovieListContract.IMovieListService service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public void getMovieListFromApi() {
        service.callMovieListApi(pageNo,this);
    }

    @Override
    public void onMovieListApiCallSuccess(MoviesListResponse moviesListResponse) {
        view.hideProgressDialog();
        view.addListToMovieAdapter(moviesListResponse);
    }

    @Override
    public void onMovieListApiCallFailure(Throwable e) {
        e.printStackTrace();
        view.showToastMessage(Utility.getErrorMessage(e));
    }
}
