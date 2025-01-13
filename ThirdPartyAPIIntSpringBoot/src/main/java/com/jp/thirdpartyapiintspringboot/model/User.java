package com.jp.thirdpartyapiintspringboot.model;


import lombok.Data;

@Data
public class User {

    private int userId;
    private int id;
    private String title;

    public User(int userId, String body, String title, int id) {
        this.userId = userId;
        this.body = body;
        this.title = title;
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    private String body;


}
