package dev.myweb.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

//ANNOTATION
@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;


    public Review createReview(String reviewBody, String imdbId){

        //create review object and insert it to the db
        Review review = reviewRepository.insert(new Review(reviewBody));

        //update reviewId of the movie class, associate the review with the movie, the reviewIds field in the db contain the array of object(review object)?
        //first() -> this make sure to update only one
        mongoTemplate.update(Movie.class).matching(Criteria.where("imdbId").is(imdbId)).apply(new Update().push("reviewIds").value(review)).first();

        return review;
    }

}
