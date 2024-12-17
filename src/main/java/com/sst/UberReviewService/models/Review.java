package com.sst.UberReviewService.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Review {

    @Id // Primary key of the table
    Long id;
}
