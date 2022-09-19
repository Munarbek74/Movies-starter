package com.company.services.impl;

import com.company.JsonIO;
import com.company.models.Director;
import com.company.models.Movie;
import com.company.services.FindAble;
import com.company.services.SortAble;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FindAbleImpl implements FindAble {


    @Override
    public void findMoviesByActor(String actorName) {

        List<Movie> list = JsonIO.getMovies();
        list.stream().filter(name -> name.getCast().get(1).getFullName().contains(actorName)).forEach(nam -> System.out.println("Фильм: " + nam.getName()));
    }

    @Override
    public void findMoviesByDirector(String directorName) {
        List<Movie> list = JsonIO.getMovies();
       list.stream().filter(name -> name.getDirector().getFullName().contains(directorName)).forEach(nam -> System.out.println("Фильм: " + nam.getName()));

    }

    @Override
    public void findMoviesByYear(int year) {
        List<Movie> list = JsonIO.getMovies();
        list.stream().filter(name -> name.getYear()==year).forEach(nam -> System.out.println("Фильм: " + nam.getName()));

    }

    @Override
    public void findMovie(String movieName) {
        List<Movie> list = JsonIO.getMovies();
         list.stream().filter(name -> name.getName().contains(movieName)).forEach(nam -> System.out.println("Фильм: " + nam.getName()));
    }

    @Override
    public void findMoviesAndRoleByActor(String actorName) {

        List<Movie> list = JsonIO.getMovies();
        list.stream().filter(name -> name.getCast().get((1)).getFullName().contains(actorName)).forEach(nam -> System.out.println("Фильм: " + nam.getName() + ", Роль: " + nam.getCast().get(1).getRole() ));
    }

    @Override
    public void showActorRoles(String actor) {

        List<Movie> list = JsonIO.getMovies();
        list.stream().distinct().sorted(Comparator.comparing(o -> o.getCast().get(1).getFullName())).forEach(nam -> System.out.println("Актер: " + nam.getCast().get(1).getFullName() + ", Роль: " + nam.getCast().get(1).getRole()));

    }
}