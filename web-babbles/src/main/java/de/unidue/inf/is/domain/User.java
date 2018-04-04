package de.unidue.inf.is.domain;

public final class User {

    private String username;
    private String name;
    private String status;
    private String photo;


    public User() {
    }


    public User(String username, String name,String status,String photo) {
        this.username = username;
        this.name = name;
        this.status=status;
        this.photo=photo;

    }


    public String getUsername() {
        return username;
    }
    public String getStatus() {
        return status;
    }
    public String getName(){return name;}
    public String getPhoto(){return photo;}

}