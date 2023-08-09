package com.bms.bookmyshowjavaspringboot.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequestDto {
    private int age;
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
}
