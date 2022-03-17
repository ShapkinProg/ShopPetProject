package ru.petProject.models;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class person {
    private int id;
    @NotEmpty(message = "Name should not be empty!")
    @Size(min = 2, max = 30, message = "Wrong name!")
    private String name;
    @NotEmpty(message = "Email should not be empty!")
    @Size(min = 6, max = 40, message = "Wrong email!")
    private String email;

    public person(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    public person()
    {

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }
}
