package com.prateek.model;

import lombok.Data;

@Data
public class Reservation {
    private long id;
    private long roomId;
    private long guestId;
    private String reservationDate;
}
