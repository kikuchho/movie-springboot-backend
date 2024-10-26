package dev.myweb.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

//spring boot annotation
@Document(collection = "movies")
@Data //no setter getter needed when we have this
@AllArgsConstructor // this takes care of constructor
@NoArgsConstructor
public class Movie {
    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres ;
    private List<String> backdrops ;

    @DocumentReference //tell the db to store only the id and the review itself is in the separate collection -> manual reference relationship
    private List<Review> reviewIds ;


}
