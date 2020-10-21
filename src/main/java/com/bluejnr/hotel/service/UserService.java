package com.bluejnr.hotel.service;

import com.bluejnr.hotel.exception.LimitationException;
import com.bluejnr.hotel.exception.RestrictionException;
import com.bluejnr.hotel.exception.TransitionException;
import com.bluejnr.hotel.model.domain.Reservation;
import com.bluejnr.hotel.model.domain.Room;

public interface UserService {

    public Reservation bookRoom(Integer userId, Reservation reservation) throws LimitationException;

    public Room stateTransition(Integer userId, Room room) throws RestrictionException, TransitionException;
}
