package com.prateek.client;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.prateek.model.Guest;


@Component
public class GuestServiceFallbackImpl implements GuestService {
    @Override
    public List<Guest> findAll(String emailAddress) {
        return Collections.emptyList();
    }

    @Override
    public Guest findOne(long id) {
    	System.out.println("Looks like Guest Service is down, provide default/dummy response");
        Guest guest = new Guest();
        guest.setFirstName("Guest");
        guest.setLastName("Occupied");
        return guest;
    }
}
