package ru.netology.poster;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PosterManagerTest {
    MoviePoster item1 = new MoviePoster(1, "Бладшот", "боевик");
    MoviePoster item2 = new MoviePoster(2, "Вперёд", "мультфильм");
    MoviePoster item3 = new MoviePoster(3, "Отель Белград", "комедия");
    MoviePoster item4 = new MoviePoster(4, "Джентльмены", "боевик");
    MoviePoster item5 = new MoviePoster(5, "Человек-невидимка", "ужасы");
    MoviePoster item6 = new MoviePoster(6, "Тролли. Мировой тур", "мультфильм");
    MoviePoster item7 = new MoviePoster(7, "Номер один", "комедия");
    MoviePoster item8 = new MoviePoster(8, "Евангелион", "аниме");
    MoviePoster item9 = new MoviePoster(9, "Человек и птица", "мультфильм");

    @Test
    void findAll() {
        PosterManager manager = new PosterManager();

        manager.addMovie(item1);
        manager.addMovie(item2);
        manager.addMovie(item3);
        manager.addMovie(item4);
        manager.addMovie(item5);
        manager.addMovie(item6);
        manager.addMovie(item7);
        manager.addMovie(item8);
        manager.addMovie(item9);

        MoviePoster[] expected = { item1, item2, item3, item4, item5, item6, item7, item8, item9 };
        MoviePoster[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void findLastIfLengthArrayLongerThanDefaultLimit() {
        PosterManager manager = new PosterManager();

        manager.addMovie(item1);
        manager.addMovie(item2);
        manager.addMovie(item3);
        manager.addMovie(item4);
        manager.addMovie(item5);
        manager.addMovie(item6);
        manager.addMovie(item7);
        manager.addMovie(item8);
        manager.addMovie(item9);

        MoviePoster[] expected = { item9, item8, item7, item6, item5 };
        MoviePoster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void findLastIfLengthArrayLessThanDefaultLimit() {
        PosterManager manager = new PosterManager();

        manager.addMovie(item1);
        manager.addMovie(item2);
        manager.addMovie(item3);

        MoviePoster[] expected = { item3, item2, item1 };
        MoviePoster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void findLastIfLengthArrayLongerThanCurrentLimit() {
        PosterManager manager = new PosterManager(6);

        manager.addMovie(item1);
        manager.addMovie(item2);
        manager.addMovie(item3);
        manager.addMovie(item4);
        manager.addMovie(item5);
        manager.addMovie(item6);
        manager.addMovie(item7);
        manager.addMovie(item8);
        manager.addMovie(item9);

        MoviePoster[] expected = { item9, item8, item7, item6, item5, item4 };
        MoviePoster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void findLastIfLengthArrayLessThanCurrentLimit() {
        PosterManager manager = new PosterManager(15);

        manager.addMovie(item1);
        manager.addMovie(item2);
        manager.addMovie(item3);
        manager.addMovie(item4);
        manager.addMovie(item5);
        manager.addMovie(item6);
        manager.addMovie(item7);

        MoviePoster[] expected = { item7, item6, item5, item4, item3, item2, item1 };
        MoviePoster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}