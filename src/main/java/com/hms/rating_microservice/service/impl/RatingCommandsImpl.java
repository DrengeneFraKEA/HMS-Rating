package com.hms.rating_microservice.service.impl;

import com.hms.rating_microservice.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingCommandsImpl {

    private RatingRepository ratingRepository;

    @Autowired
    public RatingCommandsImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }
}
