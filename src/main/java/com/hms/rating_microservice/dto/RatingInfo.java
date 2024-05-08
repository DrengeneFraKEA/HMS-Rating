package com.hms.rating_microservice.dto;

import com.hms.rating_microservice.entity.Rating;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class RatingInfo {
    private int id;
    private Rating rating;
    private String doctorName;
    private String title;
    private String text;
    private int score;
    private UUID uuid;
    private LocalDateTime modifiedDate;

}
