package com.sst.UberReviewService.repositories;
import com.sst.UberReviewService.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver,Long> {
    Optional<Driver> findByIdAndLicenseNumber(Long id, String licenseNumber);
}
