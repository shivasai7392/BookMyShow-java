package com.bms.bookmyshowjavaspringboot.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserResponseDto {
    private Long userId;
    private ResponseStatus status;
}
