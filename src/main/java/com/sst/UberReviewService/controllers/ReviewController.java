package com.sst.UberReviewService.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sst.UberReviewService.adapters.CreateReviewDtoToReviewAdapter;
import com.sst.UberReviewService.dtos.CreateReviewDto;
import com.sst.UberReviewService.dtos.ReviewDto;
import com.sst.UberReviewService.models.Review;
import com.sst.UberReviewService.services.ReviewServiceImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

   final private ReviewServiceImplementation reviewServiceImplementation;

   final private CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter;

    public ReviewController(ReviewServiceImplementation reviewServiceImplementation, CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter){
        this.reviewServiceImplementation=reviewServiceImplementation;
        this.createReviewDtoToReviewAdapter=createReviewDtoToReviewAdapter;
    }

    @GetMapping
    public List<Review> getReviews(){
        return reviewServiceImplementation.findAllReviews();
    }


    @GetMapping("/{reviewId}")
    public ResponseEntity<?> getReviewById( @PathVariable Long reviewId){
        Optional<ReviewDto> review=reviewServiceImplementation.findReviewById(reviewId);

        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> publishReview( @RequestBody CreateReviewDto request){
          Review incomingReview=this.createReviewDtoToReviewAdapter.convertDto(request);
          if(incomingReview==null){
              return new ResponseEntity<>("Invalid arguments",HttpStatus.BAD_REQUEST);
          }
          Review review= reviewServiceImplementation.publishReview(incomingReview);
          ReviewDto resposne= ReviewDto.builder()
                  .id(review.getId())
                  .content(review.getContent())
                  .booking(review.getBooking().getId())
                  .rating(review.getRating())
                  .createdAt(review.getCreatedAt())
                  .updatedAt(review.getUpdatedAt())
                  .build();
          return new ResponseEntity<>(resposne, HttpStatus.CREATED);
    }
}
