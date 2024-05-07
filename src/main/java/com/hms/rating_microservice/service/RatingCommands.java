package com.hms.rating_microservice.service;

import com.hms.rating_microservice.dto.RatingInfo;

public interface RatingCommands {
    RatingInfo createRating(RatingInfo ratingInfo);
    void deleteRating(RatingInfo ratingInfo);
}
