package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

@Entity
public class Episode extends Reviewable {

    public Episode() {
        super();
    }

    @Override
    public void addReview(Review review) {
        reviews.add(review);
    }

    @Override
    public Double getRating() {
        return reviews.stream().mapToDouble(Review::getRating).sum()/reviews.size();
    }

    @Override
    public ArrayList<Review> getReviews() {
        return null;
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
                .filter(review -> review.getlanguage()==location)
                .collect(Collectors.toCollection(ArrayList::new));
        return aReviews;
    }
    public Episode(String id, String episodePrimaryTitle, String originalTitle, Integer releaseYear,
                   ArrayList<String> genres, ArrayList<Actor> actors, ArrayList<Review> reviews) {
        super(id, "Episode", episodePrimaryTitle, originalTitle, releaseYear, genres, actors, reviews);
    }
    @Override
    public ArrayList<Review> getReviewsByType(String type) {
        ArrayList<Review> aReviews = reviews.stream()
                .filter(review -> review.getType()==type)
                .collect(Collectors.toCollection(ArrayList::new));
        return aReviews;
    }
    @Override
    public ArrayList<Review> getReviewsLikes() {
        ArrayList<Review> aReviews = reviews.stream()
                .filter(review -> review.getlike()>=1)
                .collect(Collectors.toCollection(ArrayList::new));
        return aReviews;
    }
    @Override
    public ArrayList<Review> getReviewsDislikes() {
        ArrayList<Review> aReviews = reviews.stream()
                .filter(review -> review.getdislike()>=1)
                .collect(Collectors.toCollection(ArrayList::new));
        return aReviews;
    }
    @Override
    public ArrayList<Review> getReviewsOrderByLikes() {
        ArrayList<Review> aReviews = reviews.stream()
                .sorted(Comparator.comparingInt(Review::getlike).reversed())
                .collect(Collectors.toCollection(ArrayList::new));
        return aReviews;
    }

    @Override
    public void reportReview(String idReview) {
        if( reviews.contains(getReview(idReview))){
            reviews.remove(getReview(idReview));
        }
    }
    @Override
    public boolean hasSomeReviewWithMoreStarThan(int reviewStar) {

        return reviews.stream()
                .anyMatch(review -> review.getRating()>=reviewStar);

    }
}
