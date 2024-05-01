package com.hms.rating_microservice.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class RatingInfo {
    private int patientId;
    private int doctorId;
    private String title;
    private String text;
    private int score;
    private UUID uuid;
    private LocalDateTime modifiedDate;
}