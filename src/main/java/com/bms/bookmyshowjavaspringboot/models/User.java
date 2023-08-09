package com.bms.bookmyshowjavaspringboot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class User extends BaseModel{
    private int age;

    private String name;

    private String email;

    private String phoneNumber;

    private String password;

    @OneToMany(mappedBy = "bookedBy")
    private List<Ticket> tickets;
}
