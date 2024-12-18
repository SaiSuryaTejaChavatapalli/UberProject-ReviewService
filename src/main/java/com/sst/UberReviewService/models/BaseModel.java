package com.sst.UberReviewService.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
// Handling inheritance in Spring Data JPA
// No Table for the parent class
// One Table for each child class having it's own attributes & parent class attribute.
public class BaseModel {

    @Id // Primary key of the table
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate // Tells spring that only handle it for object creation
    private Date createdAt;


    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP) // Tells spring about the format of Date Object to be stored i.e Date/ Time / TimeStamp
    @LastModifiedDate // Tells spring that only handle it for object update
    private Date updatedAt;
}
