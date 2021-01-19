package com.mycompany.dvdstore.api;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.form.MovieForm;
import com.mycompany.dvdstore.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class MovieResource {

    private MovieServiceInterface movieService;

    @Autowired
    public void setMovieService(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movie/{id}")
    public Movie get(@PathVariable("id") Long id){
        return movieService.getMovieById(id);
    }

    @PostMapping("")
    public Movie add(@RequestBody Movie movie){
        return movieService.registerMovie(movie);
    }

    @GetMapping("/movie")
    public Iterable<Movie> list() {
        return movieService.getMovieList();
    }
}
