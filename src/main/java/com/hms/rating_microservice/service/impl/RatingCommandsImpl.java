package com.hms.rating_microservice.service.impl;

import com.hms.rating_microservice.dto.RatingInfo;
import com.hms.rating_microservice.entity.Rating;
import com.hms.rating_microservice.entity.RatingDescription;
import com.hms.rating_microservice.repository.RatingRepository;
import com.hms.rating_microservice.service.RatingCommands;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingCommandsImpl implements RatingCommands {

    private RatingRepository ratingRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public RatingCommandsImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    @Transactional
    public RatingInfo createRating(RatingInfo ratingInfo){
        RatingDescription rating = new RatingDescription();

        Rating existingRating = ratingInfo.getRating();

        if (existingRating == null || existingRating.getId() == 0) {
            existingRating = new Rating();
        } else {
            // for updating
            existingRating = entityManager.merge(existingRating);
        }

        rating.setRating(existingRating);
        rating.setDoctorId(ratingInfo.getDoctorId());
        rating.setPatientId(ratingInfo.getPatientId());
        rating.setUuid(ratingInfo.getUuid());
        rating.setTitle(ratingInfo.getTitle());
        rating.setText(ratingInfo.getText());
        rating.setScore(ratingInfo.getScore());
        rating.setModifiedDate(ratingInfo.getModifiedDate());

        RatingDescription newRating = ratingRepository.save(rating);

        RatingInfo ratingResponse = new RatingInfo();
        ratingResponse.setId(newRating.getId());
        ratingResponse.setRating(newRating.getRating());
        ratingResponse.setDoctorId(newRating.getDoctorId());
        ratingResponse.setPatientId(newRating.getPatientId());
        ratingResponse.setUuid(newRating.getUuid());
        ratingResponse.setTitle(newRating.getTitle());
        ratingResponse.setText(newRating.getText());
        ratingResponse.setScore(newRating.getScore());
        ratingResponse.setModifiedDate(newRating.getModifiedDate());

        return ratingResponse;
    }


    @Override
    public RatingInfo deleteRating(RatingInfo ratingInfo) {
        return null;
    }

}
