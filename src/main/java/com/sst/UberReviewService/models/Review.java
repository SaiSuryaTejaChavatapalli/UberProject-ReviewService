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
@EntityListeners(AuditingEntityListener.class)
@Table(name = "bookingreview")
public class Review {

    @Id // Primary key of the table
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    private Double rating;


    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate // Tells spring that only handle it for object creation
    private Date createdAt;


    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP) // Tells spring about the format of Date Object to be stored i.e Date/ Time / TimeStamp
    @LastModifiedDate // Tells spring that only handle it for object update
    private Date updatedAt;
}
