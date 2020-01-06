package com.prateek.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.prateek.entity.ReservationEntity;

public interface ReservationRepository extends CrudRepository<ReservationEntity, Long> {
	List<ReservationEntity> findByDate(Date date);
}