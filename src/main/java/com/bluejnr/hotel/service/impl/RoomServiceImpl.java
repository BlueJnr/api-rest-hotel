package com.bluejnr.hotel.service.impl;

import com.bluejnr.hotel.model.domain.State;
import com.bluejnr.hotel.model.domain.Type;
import com.bluejnr.hotel.repository.RoomRepository;
import com.bluejnr.hotel.model.domain.Room;
import com.bluejnr.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;


    @Override
    public List<Room> getAllRooms() {
        List<com.bluejnr.hotel.model.entity.Room> rooms = (List<com.bluejnr.hotel.model.entity.Room>)roomRepository.findAll();
        return rooms.stream().map(this::parse).collect(Collectors.toList());
    }

    @Override
    public Room getRoomById(Integer id) {
        com.bluejnr.hotel.model.entity.Room room = roomRepository.findById(id).get();
        return parse(room);
    }

    @Override
    public List<Room> getRoomByState(String state) {
        return getAllRooms()
                .stream()
                .filter(room -> state.equals(room.getType().name()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Room> getRoomByType(String type) {
        return getAllRooms()
                .stream()
                .filter(room -> type.equals(room.getType().name()))
                .collect(Collectors.toList());
    }
    @Override
    public Room createRoom(Room room) {
        return parse(roomRepository.save(parse(room)));
    }

    @Override
    public Room updateRoom(Room room) {
        return parse(roomRepository.save(parse(room)));
    }

    @Override
    public void deleteRoomById(Integer id) {
        roomRepository.deleteById(id);
    }

    private Room parse(com.bluejnr.hotel.model.entity.Room room) {
        return Room.builder()
                .id(room.getId())
                .type(Type.valueOf(room.getType()))
                .state(State.valueOf(room.getState()))
                .build();
    }

    private com.bluejnr.hotel.model.entity.Room parse(Room room) {
        return com.bluejnr.hotel.model.entity.Room
                .builder()
                .id(room.getId())
                .type(room.getType().name())
                .state(room.getState().name())
                .build();
    }
}
