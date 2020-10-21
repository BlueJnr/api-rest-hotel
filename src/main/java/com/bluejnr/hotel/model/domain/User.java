package com.bluejnr.hotel.model.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class User {

    private Integer id;
    private Rol rol;
}
