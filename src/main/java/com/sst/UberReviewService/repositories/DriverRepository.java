package com.sst.UberReviewService.repositories;
import com.sst.UberReviewService.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver,Long> {
    Optional<Driver> findByIdAndLicenseNumber(Long id, String licenseNumber);


    // RAW Mysql query, error is thrown at runtime
    @Query(nativeQuery = true,value = "SELECT * FROM Driver WHERE id= :id AND license_number= :license")
    Optional<Driver> rawFindByIdAndLicenseNumber(Long id, String license);


    //Hibernate query, error is thrown at compile time
    @Query("SELECT d FROM Driver d WHERE d.id = :id AND d.licenseNumber = :license")
    Optional<Driver> hqlFindByIdAndLicense(Long id, String license);
}
