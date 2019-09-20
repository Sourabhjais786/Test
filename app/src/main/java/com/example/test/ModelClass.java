package com.example.test;

public class ModelClass {
    private String id;
    private String name;
    private String username;
    private String email;

    public ModelClass(String id, String name, String username, String email) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
    }


    public String getName() {
        return name;
    }
}
