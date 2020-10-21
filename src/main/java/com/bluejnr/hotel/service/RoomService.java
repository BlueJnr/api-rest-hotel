package com.bluejnr.hotel.service;

import com.bluejnr.hotel.model.entity.Room;

import java.util.List;

public interface RoomService {

    public List<Room> getAllRooms();

    public Room getRoomById(Integer id);

    public Room createRoom(Room room);

    public Room updateRoom(Room room);

    public void deleteRoomById(Integer id);
}
