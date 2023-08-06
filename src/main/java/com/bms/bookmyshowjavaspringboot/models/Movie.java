package com.bms.bookmyshowjavaspringboot.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel{
    private String name;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Genre> genres;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Language> languages;

    private LocalTime runtime;
}
