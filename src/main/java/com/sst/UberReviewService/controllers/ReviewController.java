package com.sst.UberReviewService.controllers;


import com.sst.UberReviewService.models.Review;
import com.sst.UberReviewService.services.ReviewServiceImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.HTML;
import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

   final private ReviewServiceImplementation reviewServiceImplementation;

    public ReviewController(ReviewServiceImplementation reviewServiceImplementation){
        this.reviewServiceImplementation=reviewServiceImplementation;
    }

    @GetMapping
    public List<Review> getReviews(){
        return reviewServiceImplementation.findAllReviews();
    }

    @PostMapping
    public ResponseEntity<Review> publishReview(@RequestBody Review request){
          Review review= reviewServiceImplementation.publishReview(request);
          return new ResponseEntity<>(review, HttpStatus.CREATED);
    }
}
