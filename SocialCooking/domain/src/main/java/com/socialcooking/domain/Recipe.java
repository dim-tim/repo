package com.socialcooking.domain;


public class Recipe {

    private Long id;


    private String name;



    //TODO - add type for photo
//    private


    private String description;

//    ????
//    private boolean accepted;


    private byte mark;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte getMark() {
        return mark;
    }

    public void setMark(byte mark) {
        this.mark = mark;
    }
}
