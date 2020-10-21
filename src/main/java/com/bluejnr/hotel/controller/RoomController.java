package com.bluejnr.hotel.controller;

import com.bluejnr.hotel.model.domain.Room;
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
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping(value = "/{id}")
    public Room getRoomById(@PathVariable("id") Integer id) {
        return roomService.getRoomById(id);
    }

    @GetMapping(value = "/state/{state}")
    public List<Room> getRoomByState(@PathVariable("state") String state) {
        return roomService.getRoomByState(state);
    }

    @GetMapping(value = "/type/{type}")
    public List<Room> getRoomByType(@PathVariable("type") String type) {
        return roomService.getRoomByType(type);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Room createRoom(@RequestBody Room resource) {
        return roomService.createRoom(resource);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Room updateRoom(@RequestBody Room resource) {
        return roomService.updateRoom(resource);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteRoomById(@PathVariable("id") Integer id) {
        roomService.deleteRoomById(id);
    }
}
