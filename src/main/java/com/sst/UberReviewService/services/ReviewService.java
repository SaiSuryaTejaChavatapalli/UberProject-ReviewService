package com.sst.UberReviewService.services;

import com.sst.UberReviewService.models.Booking;
import com.sst.UberReviewService.models.Review;
import com.sst.UberReviewService.repositories.BookingRepository;
import com.sst.UberReviewService.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReviewService implements CommandLineRunner {

   final private ReviewRepository reviewRepository;

   final private BookingRepository bookingRepository;

    public ReviewService(
            ReviewRepository reviewRepository,
            BookingRepository bookingRepository){
        this.reviewRepository=reviewRepository;
        this.bookingRepository=bookingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("*******");
        Review r=Review.builder()
                .content("Amazing ride quality")
                .rating(3.8)
                .build();

        Booking b= Booking.builder()
                .startTime(new Date())
                .endTime(new Date())
                .review(r)
                .build();

//        reviewRepository.save(r);
   bookingRepository.save(b);

        System.out.println(r);


//        List<Review> reviews=reviewRepository.findAll();
//        for(Review review:reviews){
//            System.out.println(review.getContent());
//        }
        //reviewRepository.deleteById(2L);
    }
}
