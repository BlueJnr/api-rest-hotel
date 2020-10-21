package com.bluejnr.hotel.controller;

import com.bluejnr.hotel.model.entity.Room;
import com.bluejnr.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping
    public List<Room> getTasks() {
        return roomService.getAllRooms();
    }

    @GetMapping(value = "/{id}")
    public Room findById(@PathVariable("id") Integer id) {
        return roomService.getRoomById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Room create(@RequestBody Room resource) {
        return roomService.createRoom(resource);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Room update(@RequestBody Room resource) {
        return roomService.updateRoom(resource);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Integer id) {
        roomService.deleteRoomById(id);
    }
}
