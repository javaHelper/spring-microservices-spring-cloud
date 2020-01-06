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

import com.prateek.model.Guest;
import com.prateek.repository.GuestRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value = "/guests")
@Api(tags = "guests")
public class GuestController {

	@Autowired
	private GuestRepository guestRepository;

	@ApiOperation(value = "Get All Guests", notes = "Gets all guests in the system", nickname = "getGuests")
	@GetMapping
	public List<Guest> findAll(@RequestParam(name = "emailAddress", required = false) String emailAddress) {
		if (StringUtils.isNotBlank(emailAddress)) {
			return Collections.singletonList(this.guestRepository.findByEmailAddress(emailAddress));
		}
		return (List<Guest>) this.guestRepository.findAll();
	}

	@GetMapping(value = "/{id}")
	public Guest findOne(@PathVariable(name = "id") Long id) {
		 Optional<Guest> optionalGuest = this.guestRepository.findById(id);
		 if(optionalGuest.isPresent()) {
			 optionalGuest.get();
		 }
		return null;
	}
}