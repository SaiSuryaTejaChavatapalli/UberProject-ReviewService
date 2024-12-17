package com.sst.UberReviewService.models;


import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Table(name = "bookingreview")
public class Review {

    @Id // Primary key of the table
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String content;

    Double rating;


    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate // Tells spring that only handle it for object creation
    Date createdAt;


    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP) // Tells spring about the format of Date Object to be stored i.e Date/ Time / TimeStamp
    @LastModifiedDate // Tells spring that only handle it for object update
    Date updatedAt;
}
