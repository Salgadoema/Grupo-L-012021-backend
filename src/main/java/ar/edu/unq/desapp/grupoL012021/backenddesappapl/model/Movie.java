package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Entity
public class Movie extends Reviewable {

    public Movie() {
        super();
    }

    public Movie(String id, String moviePrimaryTitle, String originalTitle, Integer releaseYear,
                 ArrayList<String> genres, ArrayList<Actor> actors, ArrayList<Review> reviews) {
        super(id, "Movie", moviePrimaryTitle, originalTitle, releaseYear, genres, actors, reviews);
    }
    public  void addReview(Review review){
        reviews.add(review);
    }

    @Override
    public Double getRating() {
            return reviews.stream().mapToDouble(Review::getRating).sum()/reviews.size();
    }

    @Override
    public Review getReview(String id) {

        Review aReview = reviews.stream()
                .filter(review -> id.equals(review.getId()))
                .findAny()
                .orElse(null);

        return aReview;
    }

    @Override
    public Review getReviewByPlatform(String platform) {
        Review aReview = reviews.stream()
                .filter(review -> platform.equals(review.getPlatform()))
                .findAny()
                .orElse(null);

        return aReview;
    }

    @Override
    public ArrayList<Review> getReviewsByPlatform(String platform) {
        ArrayList<Review> aReviews = reviews.stream()
                .filter(review -> review.getPlatform()==platform)
                .collect(Collectors.toCollection(ArrayList::new));
        return aReviews;
    }

    @Override
    public ArrayList<Review> getReviewsByContainSpoiler(boolean containSpoiler) {
        ArrayList<Review> aReviews = reviews.stream()
                .filter(review -> review.getContainSpoiler()==containSpoiler)
                .collect(Collectors.toCollection(ArrayList::new));
        return aReviews;
    }

    @Override
    public ArrayList<Review> getReviewsByLanguage(String language) {
        ArrayList<Review> aReviews = reviews.stream()
                .filter(review -> review.getlanguage()==language)
                .collect(Collectors.toCollection(ArrayList::new));
        return aReviews;
    }

    @Override
    public ArrayList<Review> getReviewsByGeoLocation(String location) {
        ArrayList<Review> aReviews = reviews.stream()
                .filter(review -> review.getlocation()==location)
                .collect(Collectors.toCollection(ArrayList::new));
        return aReviews;
    }

    @Override
    public ArrayList<Review> getReviewsByType(String type) {
        ArrayList<Review> aReviews = reviews.stream()
                .filter(review -> review.getType()==type)
                .collect(Collectors.toCollection(ArrayList::new));
        return aReviews;
    }


}
