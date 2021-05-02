package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="title_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Reviewable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(name="review_type", insertable = false, updatable = false)
    private String reviewableType;

    @Column
    private String primaryTitle;

    @Column
    private String originalTitle;

    @Column
    private Integer startYear;

    @ManyToMany
    private List<Actor> actors;

    @OneToMany(mappedBy = "reviewable")
    public List<Review> reviews;

    @ManyToMany
    private List<Genre> genres;

    public Reviewable() {
        super();
    }

    public Reviewable(Integer id, String reviewableType, String primaryTitle, String originalTitle,
                      Integer startYear, List<Genre> genres, List<Actor> actors, List<Review> reviews) {

        this.id = id;
        this.reviewableType = reviewableType;
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


    public Integer  getId(){
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
