package com.sst.UberReviewService.services;

import com.sst.UberReviewService.dtos.ReviewDto;
import com.sst.UberReviewService.models.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    public Optional<ReviewDto> findReviewById(Long id);

    public List<Review> findAllReviews();

    public boolean deleteReviewById(Long id);

    public  Review publishReview(Review review);
}
