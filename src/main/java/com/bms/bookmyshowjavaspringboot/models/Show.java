package com.bms.bookmyshowjavaspringboot.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Show extends BaseModel{
    private Auditorium auditorium;
    private Movie movie;
    private Date startTime;
    private Date endTime;
    private Language language;
    private List<Feature> features;
}
