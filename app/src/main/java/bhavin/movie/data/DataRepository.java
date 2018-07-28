package bhavin.movie.data;

import bhavin.movie.model.MovieDetailResponse;
import bhavin.movie.model.MoviesListResponse;
import io.reactivex.Maybe;


/**
 * Created by Bhavin on 4/9/2018.
 */

public abstract class DataRepository {

      /* public abstract Maybe<BooksCategoriesResponse> getBooksCategories();

       public abstract Maybe<BooksListByNameResponse> getBooksListFromCategory(String categoryName);*/

      public abstract Maybe<MoviesListResponse> getMoviesList(String page);
      public abstract Maybe<MovieDetailResponse> getMovieDetail(String movieId);
}