package com.mycompany.dvdstore.controller;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.form.MovieForm;
import com.mycompany.dvdstore.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    private MovieServiceInterface movieService;

    @Autowired
    public void setMovieService(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/dvdstore-home")
    public @ModelAttribute("movies") List<Movie> displayHome() {
        return movieService.getMovieList();
    }

    @GetMapping("/add-movie-form")
    public void displayMovieForm(@ModelAttribute MovieForm movie){

    }
}
