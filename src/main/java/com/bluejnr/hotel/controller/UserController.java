package com.bluejnr.hotel.controller;

import com.bluejnr.hotel.exception.LimitationException;
import com.bluejnr.hotel.exception.RestrictionException;
import com.bluejnr.hotel.exception.TransitionException;
import com.bluejnr.hotel.model.domain.Reservation;
import com.bluejnr.hotel.model.domain.Room;
import com.bluejnr.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/{id}/book")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation bookRoom(@PathVariable("id") Integer userId, @RequestBody Reservation resource) throws LimitationException {
        return userService.bookRoom(userId, resource);
    }

    @PatchMapping(value = "/{id}/state-transition")
    @ResponseStatus(HttpStatus.OK)
    public Room stateTransition(@PathVariable("id") Integer userId, @RequestBody Room resource) throws RestrictionException, TransitionException {
        return userService.stateTransition(userId, resource);
    }

}
