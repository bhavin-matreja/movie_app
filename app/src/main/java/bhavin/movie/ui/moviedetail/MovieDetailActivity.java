package bhavin.movie.ui.moviedetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import bhavin.movie.R;
import bhavin.movie.model.MovieDetailResponse;
import bhavin.movie.ui.base.BaseActivity;
import bhavin.movie.util.IntentConstants;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieDetailActivity extends BaseActivity implements MovieDetailContract.IMovieDetailView {

    @BindView(R.id.tv_movie_name) TextView tvMovieName;
    @BindView(R.id.tv_movie_desc) TextView tvMovieDesc;
    @BindView(R.id.tv_movie_runtime) TextView tvMovieRuntime;
    @BindView(R.id.tv_movie_genre) TextView tvMovieGenre;
    @BindView(R.id.toolbar)  Toolbar toolbar;
    @BindView(R.id.iv_movie_poster) ImageView ivMoviePoster;
    @BindView(R.id.rel_lay_movie_detail) RelativeLayout rlMovieDetail;

    private MovieDetailContract.IMovieDetailPresenter presenter;
    private MovieDetailContract.IMovieDetailService service;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        initialiseVariables();
    }

    private void initialiseVariables() {
        ButterKnife.bind(this);
        service = new MovieDetailService();
        presenter = new MovieDetailPresenter(this,service);

        if(getIntent().hasExtra(IntentConstants.KEY_MOVIE_ID)){
            presenter.setMovieId(getIntent().getStringExtra(IntentConstants.KEY_MOVIE_ID));
            presenter.callMovieDetailApi();
        }

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Movie Detail");
    }

    @Override
    public void setMovieDetailToViews(MovieDetailResponse movieDetailResponse) {
        getSupportActionBar().setTitle(movieDetailResponse.getTitle());
        rlMovieDetail.setVisibility(View.VISIBLE);
        tvMovieName.setText(movieDetailResponse.getTitle());
        tvMovieDesc.setText(movieDetailResponse.getOverview());
        StringBuilder movieGenre = new StringBuilder();
        for(MovieDetailResponse.Genre genre: movieDetailResponse.getGenres()){
            movieGenre.append(" " +genre.getName()+ ",");
        }
        movieGenre.deleteCharAt(movieGenre.length()-1);
        tvMovieGenre.setText(new String(movieGenre));
        tvMovieRuntime.setText(movieDetailResponse.getRuntime() + " mins");
        Picasso.get()
                .load("https://image.tmdb.org/t/p/w780/" + movieDetailResponse.getPosterPath())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .into(ivMoviePoster);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
