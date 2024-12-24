package com.sst.UberReviewService.repositories;

import com.sst.UberReviewService.models.Booking;
import com.sst.UberReviewService.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
  List<Booking> findAllByDriverId(Long driverId);

 List<Booking> findAllByDriverIn(List<Driver> driver);

}
