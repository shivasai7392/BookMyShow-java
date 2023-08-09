package com.bms.bookmyshowjavaspringboot;

import com.bms.bookmyshowjavaspringboot.controllers.UserController;
import com.bms.bookmyshowjavaspringboot.dtos.CreateUserRequestDto;
import com.bms.bookmyshowjavaspringboot.dtos.CreateUserResponseDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookmyshowjavaspringbootApplication implements CommandLineRunner {
    private UserController userController;
    public BookmyshowjavaspringbootApplication(UserController userController) {
        this.userController = userController;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookmyshowjavaspringbootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello");
        CreateUserRequestDto createUserRequestDto = new CreateUserRequestDto();
        createUserRequestDto.setAge(27);
        createUserRequestDto.setName("Shiva");
        createUserRequestDto.setEmail("shivasai7392@gmail.com");
        createUserRequestDto.setPassword("password");
        createUserRequestDto.setPhoneNumber("8919072521");

        CreateUserResponseDto createUserResponseDto = this.userController.createUser(createUserRequestDto);
        System.out.println("User with ID "+createUserResponseDto.getUserId()+" has been created.");

    }
}
