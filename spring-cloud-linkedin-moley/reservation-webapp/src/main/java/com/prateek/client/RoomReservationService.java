package com.prateek.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.prateek.domain.Room;
import com.prateek.domain.RoomReservation;


@FeignClient("RESERVATIONBUSINESSSERVICES")
public interface RoomReservationService {

    @GetMapping(value = "/rooms")
    public List<Room> getAllRooms(@RequestParam(name="roomNumber", required=false)String roomNumber);

    @GetMapping(value="/roomReservations/{date}")
    public List<RoomReservation> getRoomReservationsForDate(@PathVariable("date") String date);
}
