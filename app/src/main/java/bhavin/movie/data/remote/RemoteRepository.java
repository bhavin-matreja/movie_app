package bhavin.movie.data.remote;

import bhavin.movie.data.DataRepository;
import bhavin.movie.model.MovieDetailResponse;
import bhavin.movie.model.MoviesListResponse;
import io.reactivex.Maybe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Bhavin on 4/25/2018.
 */

public class RemoteRepository extends DataRepository {

    RetrofitService service;
    private String apiKey="55957fcf3ba81b137f8fc01ac5a31fb5";

    public RemoteRepository(Retrofit retrofit) {
        this.service = retrofit.create(RetrofitService.class);
    }

    @Override
    public Maybe<MoviesListResponse> getMoviesList(String page) {
        return service.getMovieList(apiKey,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .toMaybe();
    }

    @Override
    public Maybe<MovieDetailResponse> getMovieDetail(String movieId) {
        return service.getMovieDetail(movieId,apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .toMaybe();
    }

/*    @Override
    public Maybe<BooksCategoriesResponse>  getBooksCategories() {
        return service.getBooksCategories(apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess(new Consumer<BooksCategoriesResponse>() {
                    @Override
                    public void accept(BooksCategoriesResponse booksCategoriesResponse) throws Exception {
                        LocalRepository.getInstance().createBooksCategory(booksCategoriesResponse.getResults());
                    }
                })
                .toMaybe();
    }

    @Override
    public Maybe<BooksListByNameResponse> getBooksListFromCategory(String categoryName) {
        return service.getBooksListByCategoryName(categoryName,apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .toMaybe();
    }*/
}
