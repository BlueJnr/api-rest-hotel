package com.bluejnr.hotel.model.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Reservation {

    private Integer id;
    private Integer userId;
    private Integer roomId;
}
