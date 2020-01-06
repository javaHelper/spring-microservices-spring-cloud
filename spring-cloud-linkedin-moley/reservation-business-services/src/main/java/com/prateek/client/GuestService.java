package com.prateek.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.prateek.model.Guest;

/**
 * Annotation for interfaces declaring that a REST client with that interface should be created (e.g. for autowiring into another component). 
 * If ribbon is available it will be used to load balance the backend requests, and the load balancer can be configured using a 
 * @RibbonClient with the same name (i.e. value) as the feign client.
 */
@FeignClient(value = "GUESTSERVICES", fallback = GuestServiceFallbackImpl.class)
public interface GuestService {

    @GetMapping(value="/guests")
    List<Guest> findAll(@RequestParam(name="emailAddress", required = false)String emailAddress);

    @GetMapping(value = "/guests/{id}")
    Guest findOne(@PathVariable(name="id")long id);
}
