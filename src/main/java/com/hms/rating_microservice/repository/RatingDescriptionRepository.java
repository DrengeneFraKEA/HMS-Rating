package com.hms.rating_microservice.repository;

import com.hms.rating_microservice.entity.RatingDescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RatingDescriptionRepository extends JpaRepository<RatingDescription, Integer> {
    RatingDescription findByUuid(UUID uuid);
}
