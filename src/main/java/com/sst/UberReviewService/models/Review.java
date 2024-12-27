package com.sst.UberReviewService.models;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;


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
    private Booking booking;
    // We have a 1:1 relationship between booking and review
    // Whenever we do Entity as a composition , we have to do mapping

    @Column(nullable = false)
    private String content;

    private Double rating;

}
