package com.hms.rating_microservice.service.impl;

import com.hms.rating_microservice.dto.RatingInfo;
import com.hms.rating_microservice.entity.Rating;
import com.hms.rating_microservice.entity.RatingDescription;
import com.hms.rating_microservice.repository.RatingDescriptionRepository;
import com.hms.rating_microservice.repository.RatingRemovedRepository;
import com.hms.rating_microservice.repository.RatingRepository;
import com.hms.rating_microservice.service.RatingQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RatingQueriesImpl  implements RatingQueries {
    private RatingRepository ratingRepository;

    private RatingDescriptionRepository ratingDescriptionRepository;

    private RatingRemovedRepository ratingRemovedRepository;
    @Autowired
    public RatingQueriesImpl(RatingRepository ratingRepository, RatingDescriptionRepository ratingDescriptionRepository, RatingRemovedRepository ratingRemovedRepository) {
        this.ratingRepository = ratingRepository;
        this.ratingDescriptionRepository = ratingDescriptionRepository;
        this.ratingRemovedRepository = ratingRemovedRepository;
    }

    @Override
    public List<RatingInfo> getAllRatings() {
        List<RatingDescription> ratings = ratingDescriptionRepository.findAll();

        Set<Integer> ratingRemovedIds = ratingRemovedRepository.findAll()
                .stream()
                .map(r -> r.getRating().getId())
                .collect(Collectors.toSet());

        List<RatingDescription> activeRatings = ratings.stream()
                .filter(r -> !ratingRemovedIds.contains(r.getRating().getId()))
                .collect(Collectors.toList());

        Map<Integer, Optional<RatingDescription>> latestRatings = activeRatings.stream()
                .collect(Collectors.groupingBy(r -> r.getRating().getId(),
                        Collectors.maxBy(Comparator.comparing(RatingDescription::getModifiedDate))));

        return latestRatings.values().stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(r -> mapToDTO(r.getUuid(), r))
                .collect(Collectors.toList());
    }

    @Override
    public Rating getRatingById(int id){
        List<RatingDescription> ratings = ratingDescriptionRepository.findAll();

        Optional<RatingDescription> latestRating = ratings.stream()
                .filter(r -> r.getRating().getId() == id)
                .max(Comparator.comparing(RatingDescription::getModifiedDate));

        return latestRating.map(RatingDescription::getRating).orElse(null);
    }

    private RatingInfo mapToDTO(UUID uuid, RatingDescription ratingDescription){
        RatingInfo ratingInfo = new RatingInfo();
        ratingInfo.setUuid(uuid);
        ratingInfo.setId(ratingDescription.getId());
        ratingInfo.setRating(ratingDescription.getRating());
        ratingInfo.setDoctorName(ratingDescription.getDoctorName());
        ratingInfo.setTitle(ratingDescription.getTitle());
        ratingInfo.setText(ratingDescription.getText());
        ratingInfo.setScore(ratingDescription.getScore());
        ratingInfo.setModifiedDate(ratingDescription.getModifiedDate());
        return ratingInfo;
    }
}
