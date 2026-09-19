package com.sst.UberReviewService.services;

import com.sst.UberReviewService.models.Review;
import com.sst.UberReviewService.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService implements CommandLineRunner {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("*******************");

        Review r =Review.builder().content("Amazing ride quality").rating(5.0).build();
        reviewRepository.save(r);

        reviewRepository.deleteById(2L);

        List<Review> reviews= reviewRepository.findAll();
        for(Review review: reviews){
            System.out.println(review.getContent());
        }
    }
}
