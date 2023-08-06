package com.bms.bookmyshowjavaspringboot.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User extends BaseModel{
    private int age;
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private List<Ticket> tickets;
}
