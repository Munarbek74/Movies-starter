package com.company.services.impl;


import com.company.JsonIO;
import com.company.models.Director;
import com.company.models.Movie;
import com.company.services.SortAble;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortAbleImpl implements SortAble {



    @Override
    public void printAllMovies() {
        List<Movie> list = JsonIO.getMovies();
        list = list.stream().collect(Collectors.toList());
        System.out.println(list);
    }

    @Override
    public void sortByYear() {
        List<Movie> list = JsonIO.getMovies();
        list.stream().sorted(Comparator.comparing(Movie::getYear)).forEach(nam -> System.out.println("Фильм: " + nam.getName() + ", Год выпуска: " + nam.getYear()));

    }
    @Override
    public void sortByName() {
        List<Movie> list = JsonIO.getMovies();
        list.stream().sorted(Comparator.comparing(Movie::getName)).forEach(nam -> System.out.println("Фильм: " + nam.getName()));
        System.out.println(list);
    }

    @Override
    public void sortByDirector() {
        List<Movie> list = JsonIO.getMovies();
        list.stream().sorted(Comparator.comparing(o -> o.getDirector().getFullName())).forEach(nam -> System.out.println("Фильм: " + nam.getName() + ", Режиссер: " + nam.getDirector().getFullName()));

    }
}
