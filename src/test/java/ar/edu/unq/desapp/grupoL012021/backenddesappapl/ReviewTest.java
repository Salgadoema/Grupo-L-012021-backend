package ar.edu.unq.desapp.grupoL012021.backenddesappapl;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Movie;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.PremiumReview;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.PublicReview;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Review;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ReviewTest {
    private Movie movie;
    private Review review;
    private ArrayList<Review> reviews= new ArrayList<>();


    @BeforeEach
    public void setUp() {


   // this.review=Mockito.mock(Review.class);
  //  this.review.setRating(2.0);
       this.review = new PublicReview("R_1", 2.0, "THIS IS A REVIEW",
                "THIS IS A FULL REVIEW", new Date(14/5/2020),
                "nefli", "nefliuser","esp",
                "casa", true);

        reviews.add(review);

        this.movie = new Movie("pelicula_1",
                "Die Hard",
                "Die Hard",
                1988,
                Mockito.mock(ArrayList.class), //genres
                Mockito.mock(ArrayList.class),//actors
                reviews);//reviews
    }

    @Test
    public void MovieHasID_pelicula_1() {
        assertEquals("pelicula_1", movie.getId());
    }


    @Test
    public void addNewPublicReviewToAMovie_MovieHasOneReview() {

        movie.addReview(review);
        assertEquals(false,movie.reviews.isEmpty());

    }
    @Test
    public void movie_pelicula_1_HasNewPublicReviewWith2Stars() {

        movie.addReview(this.review);
            assertEquals(2.0, movie.getRating());
    }



    @Test
    public void movie_pelicula_1_HasNewPublicReviewWith2StarsAndAddOnewith3StarAndotherWith4_total3Star() {
        PublicReview publicReview = new PublicReview();
        publicReview.setRating(3.0);
        PremiumReview premiumReview = new PremiumReview();
        premiumReview.setRating(4.0);
        movie.addReview(publicReview);
        movie.addReview(premiumReview);

        assertEquals(3, movie.getRating());
    }

}
