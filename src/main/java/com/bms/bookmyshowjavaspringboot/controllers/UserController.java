package com.bms.bookmyshowjavaspringboot.controllers;

import com.bms.bookmyshowjavaspringboot.dtos.CreateUserRequestDto;
import com.bms.bookmyshowjavaspringboot.dtos.CreateUserResponseDto;
import com.bms.bookmyshowjavaspringboot.dtos.ResponseStatus;
import com.bms.bookmyshowjavaspringboot.models.User;
import com.bms.bookmyshowjavaspringboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public CreateUserResponseDto createUser(CreateUserRequestDto requestDto){
        CreateUserResponseDto createUserResponseDto = new CreateUserResponseDto();

        User user = this.userService.createUser(requestDto.getAge(), requestDto.getName(), requestDto.getPhoneNumber(), requestDto.getPassword(), requestDto.getEmail());
        createUserResponseDto.setUserId(user.getId());
        createUserResponseDto.setStatus(ResponseStatus.SUCCESS);

        return createUserResponseDto;
    }
}
