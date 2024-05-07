package com.hms.rating_microservice.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ratings")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @OneToMany(mappedBy = "rating", cascade = CascadeType.PERSIST)
    private List<RatingDescription> ratingDescriptionList;
    @OneToMany(mappedBy = "rating", cascade = CascadeType.PERSIST)
    private List<RatingRemoved> ratingRemovedList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
