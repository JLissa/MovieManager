package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {

    @Test
    public void getMovieNameTest() {
        MovieList list = new MovieList("First");
        String expected = "First";
        String actual = list.getName();

        Assertions.assertSame(expected, actual);
    }

    MovieManager manager = new MovieManager();

    @Test
    public void currentLimitTest() {
        MovieManager manager = new MovieManager(9);

        int expected = 9;
        int actual = manager.getNumberOfLimit();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setLimitMoreMaxTest() {

        int expected = 10;
        int actual = manager.setNumberOfLimit(11);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setNewLimitTest() {

        int expected = 7;
        int actual = manager.setNumberOfLimit(7);

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void addingMovies() {

        manager.addMovie("First");
        manager.addMovie("Second");
        manager.addMovie("Third");

        String[] expected = {"First", "Second", "Third"};
        String[] actual = manager.findAllMovies();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void outputReverseOrderTest() {
        manager.addMovie("First");
        manager.addMovie("Second");
        manager.addMovie("Third");
        manager.addMovie("Fourth");
        manager.addMovie("Fifth");
        manager.addMovie("Sixth");
        manager.addMovie("Seventh");
        manager.addMovie("Eighth");
        manager.addMovie("Ninth");
        manager.addMovie("Tenth");
        String[] expected = {"Tenth", "Ninth", "Eighth", "Seventh", "Sixth", "Fifth", "Fourth", "Third", "Second", "First"};
        String[] actual = manager.findLastMovie();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void outputInReverseOrderLessThanLimitTest() {
        manager.addMovie("First");
        manager.addMovie("Second");
        manager.addMovie("Third");
        manager.addMovie("Fourth");
        manager.addMovie("Fifth");

        String[] expected = {"Fifth", "Fourth", "Third", "Second", "First"};
        String[] actual = manager.findLastMovie();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void outputInReverseOrderMoreThanLimitTest() {
        manager.addMovie("First");
        manager.addMovie("Second");
        manager.addMovie("Third");
        manager.addMovie("Fourth");
        manager.addMovie("Fifth");
        manager.addMovie("Sixth");
        manager.addMovie("Seventh");
        manager.addMovie("Eighth");
        manager.addMovie("Ninth");
        manager.addMovie("Tenth");
        manager.addMovie("Eleventh");
        String[] expected = {"Eleventh", "Tenth", "Ninth", "Eighth", "Seventh", "Sixth", "Fifth", "Fourth", "Third", "Second"};
        String[] actual = manager.findLastMovie();

        Assertions.assertArrayEquals(expected, actual);
    }
}