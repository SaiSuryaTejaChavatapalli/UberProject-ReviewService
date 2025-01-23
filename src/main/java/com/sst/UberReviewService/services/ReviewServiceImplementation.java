package com.sst.UberReviewService.services;

import com.sst.UberReviewService.dtos.ReviewDto;
import com.sst.UberReviewService.models.Review;
import com.sst.UberReviewService.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImplementation implements ReviewService{

    ReviewRepository reviewRepository;

    public ReviewServiceImplementation(ReviewRepository reviewRepository){
        this.reviewRepository=reviewRepository;
    }

    private ReviewDto convertToDto(Review review) {
        return ReviewDto.builder()
                .id(review.getId())
                .content(review.getContent())
                .rating(review.getRating())
                .booking(review.getBooking() != null ? review.getBooking().getId() : null) // Assuming `Booking` is an entity
                .createdAt(review.getCreatedAt())
                .updatedAt(review.getUpdatedAt())
                .build();
    }

    @Override
    public Optional<ReviewDto> findReviewById(Long id) {
         return reviewRepository.findById(id)
                .map(this::convertToDto);
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

    @Override
    public Review publishReview(Review review) {
        return reviewRepository.save(review);
    }

}
