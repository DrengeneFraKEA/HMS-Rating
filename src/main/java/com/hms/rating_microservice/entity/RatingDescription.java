package com.hms.rating_microservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RatingDescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Rating rating;
    @Column(name = "patient_id", length = 10)
    private String patientId;
    @Column(name = "doctor_id", length = 10)
    private int doctorId;
    private String text;
    private UUID uuid;
    private int score;
    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

}
