package ru.netology;

public class MovieManager {

    private int limit;
    private String[] movies = new String[0];

    public MovieManager() {
        limit = 10;
    }

    public MovieManager(int limit) {
        this.limit = limit;
    }

    public int getNumberOfLimit() {
        return limit;
    }

    public int setNumberOfLimit(int newNumberOfLimit) {
        if (newNumberOfLimit > limit) {
            return limit;
        }
        limit = newNumberOfLimit;
        return limit;
    }

    public void addMovie(String movie) {
        String[] tmp = new String[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        } tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    public String[] findAllMovies() {
        return movies;
    }

    public String[] findLastMovie() {
        int resultLength;
        if (movies.length < limit) {
            resultLength = movies.length;
        } else {
            resultLength = limit;
        }
        String[] reversed = new String[resultLength];
        for (int i = 0; i < reversed.length; i++) {
            reversed[i] = movies[movies.length - 1 - i];
        }
        return reversed;
    }
}

