package com.sst.UberReviewService.repositories;
import com.sst.UberReviewService.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver,Long> {
    Optional<Driver> findByIdAndLicenseNumber(Long id, String licenseNumber);


    @Query(nativeQuery = true,value = "SELECT * FROM Driver WHERE id= :id AND license_number= :license")
    Optional<Driver> rawFindByIdAndLicenseNumber(Long id, String license);
}
