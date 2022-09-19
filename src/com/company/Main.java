package com.company;


import com.company.models.Movie;
import com.company.services.SortAble;
import com.company.services.impl.FindAbleImpl;
import com.company.services.impl.SortAbleImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {

    private static Scanner in = new Scanner(System.in);
    private static Scanner num = new Scanner(System.in);

    public static void main(String[] args) {
        commands();
        button();
    }


    static void commands() {
        System.out.println("--------------Commands-----------------------");
        System.out.println("Press 1 to print catalog");
        System.out.println("Press 2 to Find a Movie by full or part name");
        System.out.println("Press 3 to sort by year");
        System.out.println("Press 4 to sort by name");
        System.out.println("Press 5 to sort by director");
        System.out.println("Press 6 to find movies by actor's name");
        System.out.println("Press 7 to find movies by director's name");
        System.out.println("Press 8 to find movies by year");
        System.out.println("Press 9 to List all movies and roles by actor's name");
        System.out.println("Press 10 to sorted List of all actors with his roles");
        System.out.println("---------------------------------------------");
    }

    static String button(){
        SortAbleImpl sortAbleImpl = new SortAbleImpl();


        FindAbleImpl findAble = new FindAbleImpl();


        System.out.println("Choose a command: ");


        switch (in.nextInt()) {
            case 1:
                sortAbleImpl.printAllMovies();
                break;
            case 2:
               findAble.findMovie(num.nextLine());
                break;
            case 3:
                sortAbleImpl.sortByYear();
                break;
            case 4:
                sortAbleImpl.sortByName();
                break;
            case 5:
                sortAbleImpl.sortByDirector();
                break;
            case 6:
                System.out.println("Введи имя актера");
                findAble.findMoviesByActor(num.nextLine());
                break;
            case 7:
                System.out.println("Введи имя режиссера");
                findAble.findMoviesByDirector(num.nextLine());
                break;
            case 8:
                System.out.println("Введи год");
                findAble.findMoviesByYear(num.nextInt());
                break;
            case 9:
                System.out.println("Введи имя актера");
                findAble.findMoviesAndRoleByActor(num.nextLine());
                break;
            case 10:
                System.out.println("Введи имя актера");
                findAble.showActorRoles(num.nextLine());
                break;

        }    return in.nextLine();
    }
}