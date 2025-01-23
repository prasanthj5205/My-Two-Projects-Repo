package com.jp;

public class Customer {

    private int id;
    private String name;
    private String address;
    private String phone;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String defineCustomer(int id, String name) {

        return ("Your customer ID is " + id + " and NAME is " + name);
    }
}
