package com.bluejnr.hotel.service.impl;

import com.bluejnr.hotel.exception.RestrictionException;
import com.bluejnr.hotel.exception.TransitionException;
import com.bluejnr.hotel.model.domain.*;
import com.bluejnr.hotel.repository.ReservationRepository;
import com.bluejnr.hotel.repository.RoomRepository;
import com.bluejnr.hotel.repository.UserRepository;
import com.bluejnr.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Room stateTransition(Integer userId, Room room) throws RestrictionException, TransitionException {
        validUser((userId));
        validStateTransition(room);
        return parse(roomRepository.save(parse(room)));
    }

    private void validStateTransition(Room room) throws TransitionException {
        Room roomValidate = parse(roomRepository.findById(room.getId()).get());

        boolean result = false;

        switch (roomValidate.getState()){
            case FREE:
                result = (room.getState() == State.BUSY ||room.getState() == State.MAINTENANCE);
                break;
            case BUSY:
                result = (room.getState() == State.MAINTENANCE ||room.getState() == State.CLEANING);
                break;
            case CLEANING:
                result = (room.getState() == State.FREE ||room.getState() == State.MAINTENANCE);
                break;
            case MAINTENANCE:
                result = (room.getState() == State.FREE ||room.getState() == State.CLEANING);
                break;
            default:
                break;
        }

        if(!result){
            throw new TransitionException("Transition from state " + roomValidate.getState().name()
                    + " to state " + room.getState().name() + " is a bad request");
        }

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
