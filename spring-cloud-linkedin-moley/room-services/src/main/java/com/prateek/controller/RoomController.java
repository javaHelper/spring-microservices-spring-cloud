package com.prateek.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prateek.entity.Room;
import com.prateek.repository.RoomRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value="/rooms")
@Api(tags="ROOM API")
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;

    @ApiOperation(value="Get All Rooms", notes="Gets all rooms in the system", nickname="getRooms")
    @GetMapping()
    public List<Room> findAll(@RequestParam(name="roomNumber", required = false)String roomNumber){
        if(StringUtils.isNotEmpty(roomNumber)){
            return Collections.singletonList(this.roomRepository.findByRoomNumber(roomNumber));
        }
        return (List<Room>) this.roomRepository.findAll();
    }

    @ApiOperation(value="Get Room", notes="Gets a single room based on its unique id", nickname = "getRoom")
    @GetMapping(value="/{id}")
    public Room findOne(@PathVariable("id")Long id){
    	Optional<Room> optionalRoom = this.roomRepository.findById(id);
    	if(optionalRoom.isPresent()) {
    		optionalRoom.get();
    	}
        return null;
    }
}
