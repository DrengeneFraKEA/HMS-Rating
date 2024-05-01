package com.hms.rating_microservice.service.impl;

import com.hms.rating_microservice.dto.RatingInfo;
import com.hms.rating_microservice.entity.RatingDescription;
import com.hms.rating_microservice.repository.RatingRepository;
import com.hms.rating_microservice.service.RatingQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RatingQueriesImpl  implements RatingQueries {
    private RatingRepository ratingRepository;
    @Autowired
    public RatingQueriesImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public List<RatingInfo> getAllRatings() {
        List<RatingDescription> ratings = ratingRepository.findAll();
        return ratings.stream().map(r -> mapToDTO(r.getUuid(), r)).collect(Collectors.toList());
    }

    private RatingInfo mapToDTO(UUID uuid, RatingDescription ratingDescription){
        RatingInfo ratingInfo = new RatingInfo();
        ratingInfo.setUuid(uuid);
        ratingInfo.setPatientId(ratingDescription.getPatientId());
        ratingInfo.setDoctorId(ratingDescription.getDoctorId());
        ratingInfo.setTitle(ratingDescription.getTitle());
        ratingInfo.setText(ratingDescription.getText());
        ratingInfo.setScore(ratingDescription.getScore());
        ratingInfo.setModifiedDate(ratingDescription.getModifiedDate());
        return ratingInfo;
    }
}