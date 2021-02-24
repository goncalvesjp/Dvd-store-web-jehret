package com.mycompany.dvdstore.form;

import com.mycompany.dvdstore.entity.Actor;
import com.mycompany.dvdstore.entity.Movie;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class MovieForm {

    private Long id;

    @NotBlank(message = "Veuillez entrer un titre")
    @Size(min = 0, max = 20 , message = "Entrez un titre de 20 caractères au plus")
    private String title;
    @NotBlank(message = "Veuillez choisir un genre")
    private String genre;
    @Size(min = 0, max = 255, message = "Entrez une description de 255 caractères au plus")
    private String description;

    @Size(min = 0, max = 20, message = "Entrez un nom de 20 caractères au plus")
    private String firstNameActor;

    @NotBlank(message = "Veuillez entrer un prenom")
    @Size(min = 0, max = 20, message = "Entrez un prenom de 20 caractères au plus")
    private String lastNameActor;

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
        movie.setMainActor(new Actor(this.getFirstNameActor(),this.getLastNameActor()));
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

    public String getFirstNameActor() {
        return firstNameActor;
    }

    public void setFirstNameActor(String firstNameActor) {
        this.firstNameActor = firstNameActor;
    }

    public String getLastNameActor() {
        return lastNameActor;
    }

    public void setLastNameActor(String lastNameActor) {
        this.lastNameActor = lastNameActor;
    }
}
