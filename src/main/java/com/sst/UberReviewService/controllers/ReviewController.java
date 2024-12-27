package com.sst.UberReviewService.controllers;


import com.sst.UberReviewService.models.Review;
import com.sst.UberReviewService.services.ReviewServiceImplementation;
import org.springframework.web.bind.annotation.*;

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
    public Review publishReview(@RequestBody Review review){
        return reviewServiceImplementation.publishReview(review);
    }
}
