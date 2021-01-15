package com.mycompany.dvdstore.controller;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.form.MovieForm;
import com.mycompany.dvdstore.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/{id}")
    public String displayMovieCard(@PathVariable("id") Long id, Model model){
        Movie movie =  movieService.getMovieById(id);
        model.addAttribute("movie", movie);
        return "movie-details";
    }

    @PostMapping("")
    public String addMovie(@Valid @ModelAttribute MovieForm movieForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "add-movie-form";
        } else {
            movieService.registerMovie(movieForm.movieFormToMovie());
            return "movie-added";
        }
    }
}
