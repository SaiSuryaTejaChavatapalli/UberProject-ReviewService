package com.sst.UberReviewService.services;

import com.sst.UberReviewService.models.Driver;
import com.sst.UberReviewService.repositories.DriverRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DriverService implements CommandLineRunner {

    final private DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository){
        this.driverRepository=driverRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        // List<Driver> drivers=driverRepository.findAll();
        Optional<Driver> driver=driverRepository.findByIdAndLicenseNumber(1L,"AP1234");
        if(driver.isPresent()){
            System.out.println("Driver "+driver.get().getName());
        }
        //        if(driver.isPresent()){
        //          System.out.println(driver.get().getName());
        //        }


    }



}
