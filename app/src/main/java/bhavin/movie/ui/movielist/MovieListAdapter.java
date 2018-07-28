package bhavin.movie.ui.movielist;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import bhavin.movie.R;
import bhavin.movie.model.MoviesListResponse;
import bhavin.movie.ui.moviedetail.MovieDetailActivity;
import bhavin.movie.util.IntentConstants;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {

    private Context context;
    private ArrayList<MoviesListResponse.Result> moviesList;

    public MovieListAdapter(Context context, ArrayList<MoviesListResponse.Result> moviesList) {
        this.context = context;
        this.moviesList = moviesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_movie_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvMovieTitle.setText(moviesList.get(position).getOriginalTitle());
        holder.tvMovieReleaseDate.setText(moviesList.get(position).getReleaseDate());
        holder.tvMovieRating.setText(Float.toString(moviesList.get(position).getVoteAverage()));
        Picasso.get()
                .load("https://image.tmdb.org/t/p/w780/" + moviesList.get(position).getPosterPath())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .into(holder.ivMoviePoster);
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_movie_poster) ImageView ivMoviePoster;
        @BindView(R.id.tv_movie_title) TextView tvMovieTitle;
        @BindView(R.id.tv_movie_release_date) TextView tvMovieReleaseDate;
        @BindView(R.id.tv_rating) TextView tvMovieRating;
        @BindView(R.id.card_view) CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.card_view)
        public void onMovieItemClicked() {
            Intent intent = new Intent(context, MovieDetailActivity.class);
            intent.putExtra(IntentConstants.KEY_MOVIE_ID, String.valueOf(moviesList.get(getAdapterPosition()).getId()));
            context.startActivity(intent);
        }
    }
}
