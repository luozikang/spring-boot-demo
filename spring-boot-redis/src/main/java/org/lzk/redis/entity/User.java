package org.lzk.redis.entity;

public class User {
    private final String year;
    private final String email;
    private final String firstName;
    private final String lastName;
    private final String konw;




    public User(String email, String firstName, String lastName, String know, String year) {
        this.email=email;
        this.firstName = firstName;
        this.lastName=lastName;
        this.konw= know;
        this.year=  year;
    }

    public String getYear() {
        return year;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getKonw() {
        return konw;
    }
}
