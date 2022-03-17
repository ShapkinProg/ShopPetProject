package ru.petProject.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class pic {
    private int id;
    @NotEmpty(message = "Name should not be empty!")
    @Size(min = 3, max = 30, message = "Wrong name!")
    private String title;
    private int cost;
    @NotEmpty(message = "Name should not be empty!")
    @Size(min = 3, max = 100, message = "Wrong name!")
    private String description;
    @NotEmpty(message = "Name should not be empty!")
    private String picture;

    public pic(int id, String title, int cost, String description, String picture) {

        this.id = id;
        this.title = title;
        this.cost = cost;
        this.description = description;
        this.picture = picture;
    }

    public pic() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
