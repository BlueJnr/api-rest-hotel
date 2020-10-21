package com.bluejnr.hotel.service;

import com.bluejnr.hotel.model.domain.Room;

import java.util.List;

public interface RoomService {

    public List<Room> getAllRooms();

    public Room getRoomById(Integer id);

    public List<Room> getRoomByState(String state);

    public List<Room> getRoomByType(String type);

    public Room createRoom(Room room);

    public Room updateRoom(Room room);

    public void deleteRoomById(Integer id);
}
