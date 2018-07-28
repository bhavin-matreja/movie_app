package bhavin.movie.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MoviesListResponse {

    @SerializedName("results")
    @Expose
    private ArrayList<Result> results = null;
    @SerializedName("page")
    @Expose
    private int page;
    @SerializedName("total_results")
    @Expose
    private int totalResults;
    @SerializedName("dates")
    @Expose
    private Dates dates;
    @SerializedName("total_pages")
    @Expose
    private int totalPages;

    public ArrayList<Result> getResults() {
        return results;
    }

    public int getPage() {
        return page;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public Dates getDates() {
        return dates;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public class Dates {

        @SerializedName("maximum")
        @Expose
        private String maximum;
        @SerializedName("minimum")
        @Expose
        private String minimum;
    }

    public class Result {

        @SerializedName("vote_count")
        @Expose
        private int voteCount;
        @SerializedName("id")
        @Expose
        private int id;
        @SerializedName("video")
        @Expose
        private boolean video;
        @SerializedName("vote_average")
        @Expose
        private float voteAverage;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("popularity")
        @Expose
        private float popularity;
        @SerializedName("poster_path")
        @Expose
        private String posterPath;
        @SerializedName("original_language")
        @Expose
        private String originalLanguage;
        @SerializedName("original_title")
        @Expose
        private String originalTitle;
        @SerializedName("genre_ids")
        @Expose
        private ArrayList<Integer> genreIds = null;
        @SerializedName("backdrop_path")
        @Expose
        private String backdropPath;
        @SerializedName("adult")
        @Expose
        private boolean adult;
        @SerializedName("overview")
        @Expose
        private String overview;
        @SerializedName("release_date")
        @Expose
        private String releaseDate;

        public int getVoteCount() {
            return voteCount;
        }

        public int getId() {
            return id;
        }

        public boolean isVideo() {
            return video;
        }

        public float getVoteAverage() {
            return voteAverage;
        }

        public String getTitle() {
            return title;
        }

        public float getPopularity() {
            return popularity;
        }

        public String getPosterPath() {
            return posterPath;
        }

        public String getOriginalLanguage() {
            return originalLanguage;
        }

        public String getOriginalTitle() {
            return originalTitle;
        }

        public ArrayList<Integer> getGenreIds() {
            return genreIds;
        }

        public String getBackdropPath() {
            return backdropPath;
        }

        public boolean isAdult() {
            return adult;
        }

        public String getOverview() {
            return overview;
        }

        public String getReleaseDate() {
            return releaseDate;
        }
    }
}

