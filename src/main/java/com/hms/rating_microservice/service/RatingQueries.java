package com.hms.rating_microservice.service;

import com.hms.rating_microservice.dto.RatingInfo;

import java.util.List;

public interface RatingQueries {
    List<RatingInfo> getAllRatings();
}
