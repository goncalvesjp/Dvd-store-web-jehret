package com.mycompany.dvdstore.controller;

import com.mycompany.dvdstore.form.MovieForm;
import com.mycompany.dvdstore.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/movie")
public class MovieController {

    private MovieServiceInterface movieService;

    @Autowired
    public void setMovieService(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/add")
    public String addMovie(@Valid @ModelAttribute MovieForm movieForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "add-movie-form";
        } else {
            movieService.registerMovie(movieForm.movieFormToMovie());
            return "movie-added";
        }
    }

    @GetMapping("/")
    public void displayHome(){

       // return "dvdstore-home";
    }
}
