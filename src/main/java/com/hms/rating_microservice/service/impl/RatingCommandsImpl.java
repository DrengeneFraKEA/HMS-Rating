package com.hms.rating_microservice.service.impl;

import com.hms.rating_microservice.dto.RatingInfo;
import com.hms.rating_microservice.entity.Rating;
import com.hms.rating_microservice.entity.RatingDescription;
import com.hms.rating_microservice.entity.RatingRemoved;
import com.hms.rating_microservice.repository.RatingDescriptionRepository;
import com.hms.rating_microservice.repository.RatingRemovedRepository;
import com.hms.rating_microservice.repository.RatingRepository;
import com.hms.rating_microservice.service.RatingCommands;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class RatingCommandsImpl implements RatingCommands {

    private RatingRepository ratingRepository;

    private RatingDescriptionRepository ratingDescriptionRepository;
    private RatingRemovedRepository ratingRemovedRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public RatingCommandsImpl(RatingRepository ratingRepository, RatingDescriptionRepository ratingDescriptionRepository , RatingRemovedRepository ratingRemovedRepository) {
        this.ratingRepository = ratingRepository;
        this.ratingDescriptionRepository = ratingDescriptionRepository;
        this.ratingRemovedRepository = ratingRemovedRepository;
    }

    @Override
    @Transactional
    public RatingInfo createRating(RatingInfo ratingInfo){
        UUID uuid = ratingInfo.getUuid();
        RatingDescription existingRatingWithUUID = ratingDescriptionRepository.findByUuid(uuid);
        if (existingRatingWithUUID != null) {
            return null;
        }
        RatingDescription rating = new RatingDescription();
        Rating existingRating = ratingInfo.getRating();
        if (existingRating == null || existingRating.getId() == 0) {
            existingRating = new Rating();
        } else {
            // for updating
            existingRating = entityManager.merge(existingRating);
        }

        rating.setRating(existingRating);
        rating.setDoctorName(ratingInfo.getDoctorName());
        rating.setUuid(ratingInfo.getUuid());
        rating.setTitle(ratingInfo.getTitle());
        rating.setText(ratingInfo.getText());
        rating.setScore(ratingInfo.getScore());
        rating.setModifiedDate(LocalDateTime.now());

        RatingDescription newRating = ratingDescriptionRepository.save(rating);

        RatingInfo ratingResponse = new RatingInfo();
        ratingResponse.setId(newRating.getId());
        ratingResponse.setRating(newRating.getRating());
        ratingResponse.setDoctorName(newRating.getDoctorName());
        ratingResponse.setUuid(newRating.getUuid());
        ratingResponse.setTitle(newRating.getTitle());
        ratingResponse.setText(newRating.getText());
        ratingResponse.setScore(newRating.getScore());
        ratingResponse.setModifiedDate(newRating.getModifiedDate());

        return ratingResponse;
    }


    @Override
    @Transactional
    public void deleteRating(RatingInfo ratingInfo) {
        Rating existingRating = ratingInfo.getRating();
        RatingRemoved ratingRemoved = new RatingRemoved();
        ratingRemoved.setRating(existingRating);
        ratingRemoved.setRemovedDate(LocalDateTime.now());
        ratingRemovedRepository.save(ratingRemoved);

        ratingRepository.delete(existingRating);
    }
}
