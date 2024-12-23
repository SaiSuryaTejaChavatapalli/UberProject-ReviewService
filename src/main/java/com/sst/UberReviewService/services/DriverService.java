package com.sst.UberReviewService.services;

import com.sst.UberReviewService.models.Booking;
import com.sst.UberReviewService.models.Driver;
import com.sst.UberReviewService.repositories.BookingRepository;
import com.sst.UberReviewService.repositories.DriverRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService implements CommandLineRunner {

    final private DriverRepository driverRepository;

    final private BookingRepository bookingRepository;

    public DriverService(DriverRepository driverRepository, BookingRepository bookingRepository){
        this.driverRepository=driverRepository;
        this.bookingRepository=bookingRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        // List<Driver> drivers=driverRepository.findAll();
//        Optional<Driver> driver=driverRepository.findByIdAndLicenseNumber(1L,"AP1234");
//        if(driver.isPresent()){
//            System.out.println("Driver "+driver.get().getName());
//            List<Booking> bookings= bookingRepository.findAllByDriverId(1L);
//            for(Booking booking:bookings){
//                System.out.println(booking.getBookingStatus());
//                System.out.println(booking.getDriver().getName());
//            }
//        }

        Optional<Driver> driver=driverRepository.findById(1L);
        if(driver.isPresent()){
            System.out.println(driver.get().getName());
        }
    }



}
