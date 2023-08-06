package com.bms.bookmyshowjavaspringboot.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class Movie extends BaseModel{
    private String name;
    private List<Genre> genres;
    private List<Language> languages;
    private LocalTime runtime;
}
