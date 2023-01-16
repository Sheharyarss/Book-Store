package com.example.demo.repository;

import com.example.demo.model.UpcomingRelease;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpcomingReleaseRepo extends JpaRepository<UpcomingRelease,Long> {
}
