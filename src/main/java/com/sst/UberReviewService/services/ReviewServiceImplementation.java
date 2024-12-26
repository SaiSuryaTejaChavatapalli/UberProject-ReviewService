package com.sst.UberReviewService.services;

import com.sst.UberReviewService.models.Review;
import com.sst.UberReviewService.repositories.ReviewRepository;

import java.util.List;
import java.util.Optional;

public class ReviewServiceImplementation implements ReviewService{

    ReviewRepository reviewRepository;

    public ReviewServiceImplementation(ReviewRepository reviewRepository){
        this.reviewRepository=reviewRepository;
    }

    @Override
    public Optional<Review> findReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public List<Review> findAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public boolean deleteReviewById(Long id) {
        try{
            reviewRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
