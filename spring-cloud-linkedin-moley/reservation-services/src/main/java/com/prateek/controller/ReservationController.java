package com.prateek.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prateek.entity.ReservationEntity;
import com.prateek.model.Reservation;
import com.prateek.repository.ReservationRepository;
import com.prateek.utils.DateTimeUtils;
import com.prateek.utils.ReservationTranslator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/reservations")
@Api(tags = "reservations")
public class ReservationController {

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private DateTimeUtils dateTimeUtils;

	@Autowired
	private ReservationTranslator reservationTranslator;

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Get All Reservations", notes = "Gets all reservations in the system", nickname = "getReservations")
	public List<Reservation> findAll(@RequestParam(name = "date", required = false) String date) {
		List<ReservationEntity> entities = null;
		if (StringUtils.isNotBlank(date)) {
			entities = this.reservationRepository.findByDate(this.dateTimeUtils.createDateFromDateString(date));
		} else {
			entities = (List<ReservationEntity>) this.reservationRepository.findAll();
		}
		List<Reservation> reservations = new ArrayList<>(entities.size());
		entities.forEach(entity -> {
			reservations.add(this.reservationTranslator.translateEntityToReservation(entity));
		});
		return reservations;
	}
}
