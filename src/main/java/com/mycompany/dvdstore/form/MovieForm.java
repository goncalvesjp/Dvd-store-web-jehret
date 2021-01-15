package com.mycompany.dvdstore.form;

import com.mycompany.dvdstore.entity.Movie;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class MovieForm {

    private Long id;

    @NotBlank
    @Size(min = 1, max = 20)
    private String title;
    @NotBlank
    private String genre;
    @Size(min = 0, max = 255)
    private String description;

    public MovieForm() {
    }

    public MovieForm(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    public Movie movieFormToMovie(){
        Movie movie = new Movie();
        movie.setTitle(this.getTitle());
        movie.setGenre(this.getGenre());
        movie.setDescription(this.getDescription());
        return movie;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
