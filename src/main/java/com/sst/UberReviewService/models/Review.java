package com.sst.UberReviewService.models;


import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "booking_review")
@Inheritance(strategy = InheritanceType.JOINED)
public class Review extends BaseModel {


    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(nullable = false)
    private Booking booking;
    // We have a 1:1 relationship between booking and review
    // Whenever we do Entity as a composition , we have to do mapping

    @Column(nullable = false)
    private String content;

    private Double rating;

}
