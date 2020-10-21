package com.bluejnr.hotel.model.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Room {

    private Integer id;
    private String type;
    private State state;

}
