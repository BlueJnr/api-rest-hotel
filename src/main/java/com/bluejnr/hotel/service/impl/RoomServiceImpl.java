package com.bluejnr.hotel.service.impl;

import com.bluejnr.hotel.repository.RoomRepository;
import com.bluejnr.hotel.model.entity.Room;
import com.bluejnr.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;


    @Override
    public List<Room> getAllRooms() {
        return (List<Room>) roomRepository.findAll();
    }

    @Override
    public Room getRoomById(Integer id) {
        return roomRepository.findById(id).get();
    }

    @Override
    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room updateRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public void deleteRoomById(Integer id) {
        roomRepository.deleteById(id);
    }
}
