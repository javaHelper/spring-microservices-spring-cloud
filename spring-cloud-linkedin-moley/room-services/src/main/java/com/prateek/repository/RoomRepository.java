package com.prateek.repository;

import org.springframework.data.repository.CrudRepository;

import com.prateek.entity.Room;

public interface RoomRepository extends CrudRepository<Room, Long> {
	Room findByRoomNumber(String roomNumber);
}
