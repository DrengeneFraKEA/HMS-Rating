package com.hms.rating_microservice.controller;

import com.hms.rating_microservice.dto.RatingInfo;
import com.hms.rating_microservice.service.RatingCommands;
import com.hms.rating_microservice.service.RatingQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class RatingController {

    private RatingQueries queries;
    private RatingCommands commands;
    @Autowired
    public RatingController(RatingQueries queries, RatingCommands commands) {
        this.queries = queries;
        this.commands = commands;
    }

    @GetMapping("rating")
    public ResponseEntity<List<RatingInfo>> getAllRatings(){
        return new ResponseEntity<>(queries.getAllRatings(), HttpStatus.OK);
    }

    @PostMapping("rating/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<RatingInfo> createRating(@RequestBody RatingInfo ratingInfo){
        return new ResponseEntity<>(commands.createRating(ratingInfo), HttpStatus.CREATED);
    }

}
