package com.hms.rating_microservice.service;

import com.hms.rating_microservice.dto.RatingInfo;
import com.hms.rating_microservice.entity.Rating;

import java.util.List;

public interface RatingQueries {
    List<RatingInfo> getAllRatings();
    Rating getRatingById(int id);
}
