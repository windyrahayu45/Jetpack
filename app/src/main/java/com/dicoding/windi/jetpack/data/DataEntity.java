package com.dicoding.windi.jetpack.data;

public class DataEntity {
    private String filmId;
    private String title;
    private String releaseDate;
    private String description;
    private String vote;
    private String posterPath;

    public DataEntity(String filmId, String title, String releaseDate, String description, String vote, String posterPath) {
        this.filmId = filmId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.description = description;
        this.vote = vote;
        this.posterPath = posterPath;
    }

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }
}
