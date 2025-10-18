package ru.netology.poster;

public class PosterManager {
    int limit;
    private MoviePoster[] items = new MoviePoster[0];

    public PosterManager() {
        this.limit = 5;
    }

    public PosterManager(int currentLimit) {
        this.limit = currentLimit;
    }

    public void addMovie(MoviePoster item) {
        MoviePoster[] tmp = new MoviePoster[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public MoviePoster[] findAll() {
        return items;
    }

    public MoviePoster[] findLast() {
        MoviePoster[] all = findAll();

        int resultLength;
        if (all.length < limit) {
            resultLength = all.length;
        } else {
            resultLength = limit;
        }

        MoviePoster[] result = new MoviePoster[resultLength];
        for (int i = 0; i < result.length; i++) {
            result[i] = all[all.length - 1 - i];
        }
        return result;
    }
}
