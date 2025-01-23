package com.sst.UberReviewService.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ReviewDto {
    private Long id;
    private String content;
    private  Double rating;
    private Long booking;
    private Date createdAt;
    private Date updatedAt;
}
