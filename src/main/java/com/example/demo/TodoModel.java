package com.example.demo;


public class TodoModel {
    private Integer id;
    private String title;
    private String desc;



    public TodoModel(int id, String title, String discription) {
        this.id = id;
        this.title = title;
        this.desc = discription;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscription() {
        return desc;
    }

    public void setDiscription(String discription) {
        this.desc = discription;
    }
}
