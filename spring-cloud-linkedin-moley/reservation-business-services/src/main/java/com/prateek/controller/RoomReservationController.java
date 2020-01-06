package com.prateek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prateek.client.RoomService;
import com.prateek.model.Room;
import com.prateek.model.RoomReservation;
import com.prateek.service.RoomReservationBusinessProcess;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api(tags = "roomReservations")
public class RoomReservationController {
	@Autowired
	private RoomService roomService;

	@Autowired
	private RoomReservationBusinessProcess businessProcess;

	@GetMapping(value = "/rooms")
	@ApiOperation(value = "Get All Rooms", notes = "Gets all rooms in the system", nickname = "getRooms")
	public List<Room> getAllRooms(@RequestParam(name = "roomNumber", required = false) String roomNumber) {
		return this.roomService.findAll(roomNumber);
	}

	@GetMapping(value = "/roomReservations/{date}")
	@ApiOperation(value = "Get Room Reservations", notes = "Gets all reservations for a specific date", nickname = "getReservationsForDate")
	public List<RoomReservation> getRoomReservationsForDate(@PathVariable("date") String date) {
		return this.businessProcess.getRoomReservationsForDate(date);
	}
}