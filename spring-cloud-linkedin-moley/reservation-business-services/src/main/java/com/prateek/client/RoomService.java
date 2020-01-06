package com.prateek.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.prateek.model.Room;

@FeignClient(value = "ROOMSERVICES")
public interface RoomService {

	@GetMapping(value = "/rooms")
	List<Room> findAll(@RequestParam(name = "roomNumber", required = false) String roomNumber);

	@GetMapping(value = "/rooms/{id}")
	Room findOne(@PathVariable("id") long id);
}
