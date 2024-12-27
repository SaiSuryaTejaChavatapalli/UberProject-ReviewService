package com.sst.UberReviewService.repositories;


import com.sst.UberReviewService.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    Integer countAllByRatingIsLessThanEqual(Integer givenRating);

    List<Review> findAllByRatingIsLessThanEqual(Integer givenRating);

    List<Review> findAllByCreatedAtBefore(Date date);



//    @Query("SELECT r FROM Booking b inner join Review r on b.review=r where b.id= :bookingId")
//    Review findReviewByBookingId(Long bookingId);


}
