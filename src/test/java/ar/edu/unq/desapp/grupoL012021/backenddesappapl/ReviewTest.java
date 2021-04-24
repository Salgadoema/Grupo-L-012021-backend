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
       this.review = new PublicReview("R_1","Public Review", 2.0, "THIS IS A REVIEW",
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

    @Test
    public void addAReviewWithId_R1_searchThisReviewAndAppear(){
        assertEquals(review.getId(),movie.getReview("R_1").getId());
    }

    @Test
    public void addAReviewWithPlatformOrigin_nefli_searchThisReviewAndAppear(){
        assertEquals(review.getId(),movie.getReviewByPlatform("nefli").getId());
    }

    @Test
    public void addAReviewWithSpoilertOn_True_searchThisReviewAndAppear(){
        assertEquals(review.getId(),movie.getReviewByPlatform("nefli").getId());
    }

    @Test
    public void add3Review_2ofNefliAnd1OfMamazon_SearchForNefliAndreturnAListwithThisElements(){
        PublicReview publicReview = new PublicReview();
        publicReview.setPlatform("nefli");
        PremiumReview premiumReview = new PremiumReview();
        premiumReview.setPlatform("nefli");
        PublicReview publicReview2 = new PublicReview();
        publicReview2.setPlatform("mamazon");

        movie.addReview(publicReview);
        movie.addReview(publicReview2);
        movie.addReview(premiumReview);

        assertEquals(3,movie.getReviewsByPlatform("nefli").size());
    }

    @Test
    public void movieWitAnSpoilertReviewadd3Review_2withSpoilertAlertAnd1WithoutSA_SearchForSpoilertAndreturnAListwithThisElements3(){
        PublicReview publicReview = new PublicReview();
        publicReview.setContainSpoiler(true);
        PremiumReview premiumReview = new PremiumReview();
        premiumReview.setContainSpoiler(false);
        PublicReview publicReview2 = new PublicReview();
        publicReview2.setContainSpoiler(true);

        movie.addReview(publicReview);
        movie.addReview(publicReview2);
        movie.addReview(premiumReview);

        assertEquals(3,movie.getReviewsByContainSpoiler(true).size());
    }
    @Test
    public void movieWitAnlenguajeESPadd3Review_2withLengEspAnd1WithLengENG_SearchForENGAndreturnAListwithThisElements1(){
        PublicReview publicReview = new PublicReview();
        publicReview.setLanguage("Esp");
        PremiumReview premiumReview = new PremiumReview();
        premiumReview.setLanguage("Esp");
        PublicReview publicReview2 = new PublicReview();
        publicReview2.setLanguage("Eng");

        movie.addReview(publicReview);
        movie.addReview(publicReview2);
        movie.addReview(premiumReview);

        assertEquals(1,movie.getReviewsByLanguage("Eng").size());
    }

    @Test
    public void movieWitAnLocationArgentinaadd3Review_2withLocationArgentina_and1WithLocationUSA_SearchForUSAAndreturnAListwithThisElements1(){
        PublicReview publicReview = new PublicReview();
        publicReview.setgeoLocation("Argentina");
        PremiumReview premiumReview = new PremiumReview();
        PublicReview publicReview2 = new PublicReview();
        publicReview2.setgeoLocation("USA");

        movie.addReview(publicReview);
        movie.addReview(publicReview2);
        movie.addReview(premiumReview);

        assertEquals(1,movie.getReviewsByGeoLocation("USA").size());
    }

    @Test
    public void movieWith1publicReviewAdd2publicReviewAnd1PremiumReview_SearchforPublicReviewresponse3(){
        PublicReview publicReview = new PublicReview();
        PremiumReview premiumReview = new PremiumReview();
        PublicReview publicReview2 = new PublicReview();

        publicReview.setType("Public Review");
        publicReview2.setType("Public Review");
        premiumReview.setType("Premium Review");

        movie.addReview(publicReview);
        movie.addReview(publicReview2);
        movie.addReview(premiumReview);

        assertEquals(1,movie.getReviewsByType("Premium Review").size());
    }

 /*
     Además que se pueda
    ordenar por rating y/o fecha, y que el orden sea ascendente o descendente. Además,
    los resultados deben estar paginados.*/
}
