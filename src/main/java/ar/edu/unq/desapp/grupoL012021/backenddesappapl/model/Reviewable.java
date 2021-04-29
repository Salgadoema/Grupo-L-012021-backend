package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public abstract class Reviewable {

    //tconst in imdb
    @Id
    @Column
    private String id;

    @Column
    private String titleType;

    @Column
    private String primaryTitle;

    @Column
    private String originalTitle;

    @Column
    private Integer startYear;

    @ElementCollection
    private List<String> genres;

    @ManyToMany
    private List<Actor> actors;

    @OneToMany
    public List<Review> reviews;

    public Reviewable() {
        super();
    }

    public Reviewable(String id, String titleType, String primaryTitle, String originalTitle,
                      Integer startYear, List<String> genres, List<Actor> actors, List<Review> reviews) {

        this.id = id;
        this.titleType = titleType;
        this.primaryTitle = primaryTitle;
        this.originalTitle = originalTitle;
        this.startYear = startYear;
        this.genres = genres;
        this.actors = actors;
        this.reviews = reviews;

    }

    public String getTitle() {
        return primaryTitle;
    }


    public String  getId(){
        return this.id;
    }


    public void addReview(Review review) {
        reviews.add(review);
    }


    public Double getRating() {
        return reviews.stream().mapToDouble(Review::getRating).sum()/reviews.size();
    }


    public ArrayList<Review> getReviews() {
        return (ArrayList<Review>) this.reviews;
    }


    public Review getReview(String id) {

        Review aReview = reviews.stream()
                .filter(review -> id.equals(review.getId()))
                .findAny()
                .orElse(null);

        return aReview;
    }


    public Review getReviewByPlatform(String platform) {
        Review aReview = reviews.stream()
                .filter(review -> platform.equals(review.getPlatform()))
                .findAny()
                .orElse(null);

        return aReview;
    }


    public ArrayList<Review> getReviewsByPlatform(String platform) {
        ArrayList<Review> aReviews = reviews.stream()
                .filter(review -> review.getPlatform()==platform)
                .collect(Collectors.toCollection(ArrayList::new));
        return aReviews;
    }


    public ArrayList<Review> getReviewsByContainSpoiler(boolean containSpoiler) {
        ArrayList<Review> aReviews = reviews.stream()
                .filter(review -> review.getContainSpoiler()==containSpoiler)
                .collect(Collectors.toCollection(ArrayList::new));
        return aReviews;
    }


    public ArrayList<Review> getReviewsByLanguage(String language) {
        ArrayList<Review> aReviews = reviews.stream()
                .filter(review -> review.getlanguage()==language)
                .collect(Collectors.toCollection(ArrayList::new));
        return aReviews;
    }


    public ArrayList<Review> getReviewsByGeoLocation(String location) {
        ArrayList<Review> aReviews = reviews.stream()
                .filter(review -> review.getlocation()==location)
                .collect(Collectors.toCollection(ArrayList::new));
        return aReviews;
    }


    public ArrayList<Review> getReviewsByType(String type) {
        ArrayList<Review> aReviews = reviews.stream()
                .filter(review -> review.getType()==type)
                .collect(Collectors.toCollection(ArrayList::new));
        return aReviews;
    }


    public ArrayList<Review> getReviewsLikes() {
        ArrayList<Review> aReviews = reviews.stream()
                .filter(review -> review.getlike()>=1)
                .collect(Collectors.toCollection(ArrayList::new));
        return aReviews;
    }


    public ArrayList<Review> getReviewsDislikes() {
        ArrayList<Review> aReviews = reviews.stream()
                .filter(review -> review.getdislike()>=1)
                .collect(Collectors.toCollection(ArrayList::new));
        return aReviews;
    }


    public ArrayList<Review> getReviewsOrderByLikes() {
        ArrayList<Review> aReviews = reviews.stream()
                .sorted(Comparator.comparingInt(Review::getlike).reversed())
                .collect(Collectors.toCollection(ArrayList::new));
        return aReviews;
    }


    public void reportReview(String idReview) {
        if( reviews.contains(getReview(idReview))){
            reviews.remove(getReview(idReview));
        }
    }


    public boolean hasSomeReviewWithMoreStarThan(int reviewStar) {

        return reviews.stream()
                .anyMatch(review -> review.getRating()>=reviewStar);

    }

}
