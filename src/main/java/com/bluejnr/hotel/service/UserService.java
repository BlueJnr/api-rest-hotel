package com.bluejnr.hotel.service;

import com.bluejnr.hotel.exception.RestrictionException;
import com.bluejnr.hotel.model.domain.Reservation;
import com.bluejnr.hotel.model.domain.Room;

public interface UserService {

    public Reservation bookRoom(Integer userId, Reservation reservation);

    public Room stateTransition(Integer userId, Room room) throws RestrictionException;
}
