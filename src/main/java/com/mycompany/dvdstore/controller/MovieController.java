package com.mycompany.dvdstore.controller;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class MovieController {

    @Autowired
    private MovieServiceInterface movieService;

    public void setMovieService(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }

    public void addUsingConsole() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Saisisez le titre:");
        String title = sc.nextLine();

        System.out.println("Saisisez le genre du film:");
        String genre = sc.nextLine();

        Movie movie = new Movie(title, genre);
        movieService.registerMovie(movie);
    }
}
