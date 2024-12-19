package com.sst.UberReviewService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.Date;

@Entity
public class Booking {

    @Enumerated(value = EnumType.STRING)
    private BookingStatus bookingStatus;

    private Date startTime;

    private Date endTime;

    private Long totalDistance;

}
