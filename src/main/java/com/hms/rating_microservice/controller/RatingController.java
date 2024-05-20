package com.hms.rating_microservice.controller;

import com.hms.rating_microservice.dto.RatingInfo;
import com.hms.rating_microservice.entity.Rating;
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

    /**
     * Retrieves all ratings.
     *
     * @return a response entity containing a list of RatingInfo objects and an HTTP status of OK
     */
    @GetMapping("rating")
    @CrossOrigin(origins = "http://localhost:44402")
    public ResponseEntity<List<RatingInfo>> getAllRatings(){
        return new ResponseEntity<>(queries.getAllRatings(), HttpStatus.OK);
    }

    /**
     * Creates a new rating.
     *
     * @param ratingInfo the information of the rating to be created
     * @return a response entity containing the created RatingInfo object and an HTTP status of CREATED
     */
    @PostMapping("rating/create")
    @CrossOrigin(origins = "http://localhost:44402")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<RatingInfo> createRating(@RequestBody RatingInfo ratingInfo){
        return new ResponseEntity<>(commands.createRating(ratingInfo), HttpStatus.CREATED);
    }

    /**
     * Deletes an existing rating by its ID.
     *
     * @param ratingId the ID of the rating to be deleted
     * @return a response entity containing a confirmation message and an HTTP status of OK if successful,
     *         or an HTTP status of NOT_FOUND if the rating does not exist
     */
    @PostMapping("rating/{id}/delete")
    @CrossOrigin(origins = "http://localhost:44402")
    public ResponseEntity<String> deleteRating(@PathVariable("id") int ratingId){
        Rating existingRating = queries.getRatingById(ratingId);

        if (existingRating == null) {
            return new ResponseEntity<>("Rating with id: "+ratingId+" not found", HttpStatus.NOT_FOUND);
        }

        RatingInfo rating = new RatingInfo();
        rating.setRating(existingRating);
        commands.deleteRating(rating);
        return new ResponseEntity<>("Rating with id: "+ratingId+" deleted", HttpStatus.OK);
    }

}
