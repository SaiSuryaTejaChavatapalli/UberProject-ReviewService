package com.sst.UberReviewService.controllers;

import com.sst.UberReviewService.adapters.CreateReviewDtoToReviewAdapter;
import com.sst.UberReviewService.dtos.ReviewDto;
import com.sst.UberReviewService.models.Review;
import com.sst.UberReviewService.services.ReviewServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ReviewControllerTest {

    @InjectMocks
    ReviewController reviewController;

    @Mock
    ReviewServiceImplementation reviewServiceImplementation;

    @Mock
    CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter;

    @BeforeEach // Because for isolation we need to put if before each test
    public  void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetByReviewId_Success(){

        Long reviewId=1L;
        ReviewDto mockReview=ReviewDto.builder().build();
        mockReview.setId(reviewId);

        // mocking
        when(reviewServiceImplementation.findReviewById(reviewId)).thenReturn(Optional.of(mockReview));

        // perform a test
       ResponseEntity<?> response=reviewController.getReviewById(reviewId);

        assertEquals(HttpStatus.OK,response.getStatusCode());
        Optional<ReviewDto> returnedReview= (Optional<ReviewDto>) response.getBody();
        assertEquals(reviewId,returnedReview.get().getId());

    }


}
