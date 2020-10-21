package com.bluejnr.hotel.service.impl;

import com.bluejnr.hotel.exception.RestrictionException;
import com.bluejnr.hotel.model.domain.*;
import com.bluejnr.hotel.repository.ReservationRepository;
import com.bluejnr.hotel.repository.RoomRepository;
import com.bluejnr.hotel.repository.UserRepository;
import com.bluejnr.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Reservation bookRoom(Integer userId, Reservation reservation) {
        return parse(reservationRepository.save(parse(reservation)));
    }

    @Override
    public Room stateTransition(Integer userId, Room room) throws RestrictionException {
        validUser((userId));
        return parse(roomRepository.save(parse(room)));
    }

    private void validUser(Integer userId) throws RestrictionException {
        User user = parse(userRepository.findById(userId).get());
        if(!(user.getRol() == Rol.MANAGER || user.getRol() == Rol.RECEPTIONIST)){
            throw new RestrictionException("Your " + user.getRol().name() + " role cannot make state transitions");
        }
    }

    private User parse(com.bluejnr.hotel.model.entity.User user) {
        return User.builder()
                .id(user.getId())
                .rol(Rol.valueOf(user.getRol()))
                .build();
    }

    private com.bluejnr.hotel.model.entity.Room parse(Room room) {
        return com.bluejnr.hotel.model.entity.Room.builder()
                .id(room.getId())
                .state(room.getState().name())
                .type(room.getType().name())
                .build();
    }
    private Room parse(com.bluejnr.hotel.model.entity.Room room) {
        return Room.builder()
                .id(room.getId())
                .state(State.valueOf(room.getState()))
                .type(Type.valueOf(room.getType()))
                .build();
    }

    private Reservation parse(com.bluejnr.hotel.model.entity.Reservation reservation) {
        return Reservation.builder()
                .id(reservation.getId())
                .userId(reservation.getUserId())
                .roomId(reservation.getRoomId())
                .build();
    }

    private com.bluejnr.hotel.model.entity.Reservation parse(Reservation reservation) {
        return com.bluejnr.hotel.model.entity.Reservation.builder()
                .id(reservation.getId())
                .userId(reservation.getUserId())
                .roomId(reservation.getRoomId())
                .build();
    }

}
