package dev.myweb.movies;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//ANNOTATION
@RestController
@RequestMapping("/api/v1/reviews")
@CrossOrigin(origins = "*")

public class ReviewController {


    @Autowired
    private ReviewService reviewService;

    @PostMapping //as a parametor we take requestbody, and map it to key string and value string  and call it payload
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload ) {
        return new ResponseEntity<Review>( reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId")),
        HttpStatus.CREATED );
    }

}
