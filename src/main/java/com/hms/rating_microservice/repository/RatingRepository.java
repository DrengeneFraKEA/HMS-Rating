package com.hms.rating_microservice.repository;

import com.hms.rating_microservice.entity.Rating;
import com.hms.rating_microservice.entity.RatingDescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
}
