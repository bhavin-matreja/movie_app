package bhavin.movie.ui.movielist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import bhavin.movie.R;
import bhavin.movie.model.MoviesListResponse;
import bhavin.movie.ui.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MovieListContract.IMovieListView {

    @BindView(R.id.rv_movie_list)
    RecyclerView recyclerView;

    private MovieListContract.IMovieListPresenter presenter;
    private MovieListContract.IMovieListService service;
    private MovieListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialiseVariables();
    }

    private void initialiseVariables() {

        ButterKnife.bind(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        service = new MovieListService();
        presenter = new MovieListPresenter(this,service);
        presenter.getMovieListFromApi();
    }

    @Override
    public void addListToMovieAdapter(MoviesListResponse moviesListResponse) {
        adapter = new MovieListAdapter(this,moviesListResponse.getResults());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void hideProgressDialog() {

    }
}
