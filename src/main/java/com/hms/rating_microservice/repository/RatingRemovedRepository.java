package com.hms.rating_microservice.repository;

import com.hms.rating_microservice.entity.RatingRemoved;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRemovedRepository extends JpaRepository<RatingRemoved, Integer> {
}
