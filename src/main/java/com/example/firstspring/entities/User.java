package com.example.firstspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//Can't use User, reserved keyword
//see reserved keywords at https://h2database.com/html/advanced.html#keywords

//Este entity vem do javax.persistence.Entity
@Entity
@Table(name = "app_user")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //comentado por agr
    private int userId;

    private String name;



    @OneToMany(mappedBy = "sender")
    private List<Message> messages = new ArrayList<>();

    public User() {

    }

    public User(String name) {
        // = userId; user id autogenerated
        this.name = name;
    }



    public List<Message> getMessages() {
        return messages;
    }

    public int getuserId() {
        return userId;
    }

    public void setuserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
