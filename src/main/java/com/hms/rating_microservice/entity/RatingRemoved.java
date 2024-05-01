package com.hms.rating_microservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RatingRemoved {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Rating rating;
    @Column(name = "removed_date")
    private LocalDateTime removedDate;
}
