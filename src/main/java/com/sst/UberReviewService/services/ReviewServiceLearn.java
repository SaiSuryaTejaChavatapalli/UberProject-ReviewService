//package com.sst.UberReviewService.services;
//
//import com.sst.UberReviewService.models.Booking;
//import com.sst.UberReviewService.models.Driver;
//import com.sst.UberReviewService.repositories.BookingRepository;
//import com.sst.UberReviewService.repositories.DriverRepository;
//import com.sst.UberReviewService.repositories.ReviewRepository;
//import jakarta.transaction.Transactional;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//@Service
//public class ReviewServiceLearn implements CommandLineRunner {
//
//   final private ReviewRepository reviewRepository;
//
//   final private BookingRepository bookingRepository;
//
//   final private DriverRepository driverRepository;
//
//    public ReviewService(
//            ReviewRepository reviewRepository,
//            BookingRepository bookingRepository,
//            DriverRepository driverRepository
//            ){
//        this.reviewRepository=reviewRepository;
//        this.bookingRepository=bookingRepository;
//        this.driverRepository=driverRepository;
//    }
//
//    @Override
//    @Transactional
//    public void run(String... args) throws Exception {
//        System.out.println("*******");
////        Review r=Review.builder()
////                .content("Amazing ride quality")
////                .rating(3.8)
////                .build();
////
////        Booking b= Booking.builder()
////                .startTime(new Date())
////                .endTime(new Date())
////                .review(r)
////                .build();
//
////        reviewRepository.save(r);
////   bookingRepository.save(b);
////
////        System.out.println(r);
//
//
////        List<Review> reviews=reviewRepository.findAll();
////        for(Review review:reviews){
////            System.out.println(review.getContent());
////        }
//        //reviewRepository.deleteById(2L);
//
//
//        //N+1 Queries
//        List<Long> driverIds=new ArrayList<>(Arrays.asList(1L,2L,3L));
//        System.out.println("DriverIds: "+driverIds);
//
//        List<Driver> drivers=driverRepository.findAllByIdIn(driverIds);
//
// List<Booking> driverBookings=bookingRepository.findAllByDriverIn(drivers);
//
//        for(Booking db:driverBookings){
//            System.out.println(db.getId());
//        }
//
////        for(Driver dr:drivers){
////            List<Booking> bookings= dr.getBookings();
////            bookings.forEach(booking-> System.out.println(booking.getId()));
////        }
//
//    }
//}
