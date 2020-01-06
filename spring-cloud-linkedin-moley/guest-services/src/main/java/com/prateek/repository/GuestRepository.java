package com.prateek.repository;

import org.springframework.data.repository.CrudRepository;

import com.prateek.model.Guest;

public interface GuestRepository extends CrudRepository<Guest, Long>{
    Guest findByEmailAddress(String emailAddress);
}
