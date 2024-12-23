package com.sst.UberReviewService.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking extends BaseModel{

  // 1:1 - Default Fetch Mode : Eager
  // 1:n - Default: Lazy
  // m:n - Default: Lazy
  // m:1 - Default : Eager

  @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    //@OneToOne
    private Review review;
    // We have a 1:1 relationship between booking and review
    // Whenever we do Entity as a composition , we have to do mapping
    @Enumerated(value = EnumType.STRING)
    private BookingStatus bookingStatus;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date startTime;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date endTime;

    private Long totalDistance;

    @ManyToOne
    private Driver driver;

    @ManyToOne
    private Passenger passenger;

}
