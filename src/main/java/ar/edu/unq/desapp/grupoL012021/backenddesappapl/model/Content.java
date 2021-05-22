package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="title_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(name="title_type", insertable = false, updatable = false)
    private String contentType;

    @Column
    private String primaryTitle;

    @Column
    private String originalTitle;

    @Column
    private Integer startYear;

    @ManyToMany
    @JoinColumns({
            @JoinColumn(name="content_crew_member", referencedColumnName = "id"),
            @JoinColumn(name="content_crew_member_name", referencedColumnName = "name")
    })
    private List<CrewMember> crewMembers;

    @JsonManagedReference
    @OneToMany(mappedBy = "content", fetch = FetchType.LAZY)
    public List<Review> reviews;

    @ManyToMany
    private List<Genre> genres;

    public Content() {
        super();
    }

    public Content(Integer id, String contentType, String primaryTitle, String originalTitle,
                   Integer startYear, List<Genre> genres, List<CrewMember> crewMembers, List<Review> reviews) {

        this.id = id;
        this.contentType = contentType;
        this.primaryTitle = primaryTitle;
        this.originalTitle = originalTitle;
        this.startYear = startYear;
        this.genres = genres;
        this.crewMembers = crewMembers;
        this.reviews = reviews;

    }

    public String getPrimaryTitle() {
        return primaryTitle;
    }

    public void setPrimaryTitle(String title) { this.primaryTitle = title; }

    public Integer  getId(){
        return this.id;
    }

    public void setId() { this.id = id; }

    public String getOriginalTitle() { return this.originalTitle; }

    public void setOriginalTitle(String originalTitle) { this.originalTitle = originalTitle; }

    public String getContentType() { return this.contentType; }

    public void setContentType() { this.contentType = contentType;}

    public Integer getStartYear() { return this.startYear; }

    public void setStartYear() { this.startYear = startYear; }

    public List<CrewMember> getCrewMembers() { return this.crewMembers; }

    public void setCrewMembers(List<CrewMember> crewMembers) { this.crewMembers = crewMembers; }

    public void addCrewMember(CrewMember crewMember) { this.crewMembers.add(crewMember); }

    public List<Genre> getGenres() { return this.genres; }

    public void setGenres(List<Genre> genres) { this.genres = genres; }

    public void addGenre(Genre genre) { this.genres.add(genre); }

    public void setReviews(List<Review> reviews) { this.reviews = reviews; }

    public void addReview(Review review) { reviews.add(review); }

    public void setContentType(String ContentType) {
        this.contentType = contentType;
    }

    public Double getRating() {
        return reviews.stream().mapToDouble(Review::getRating).sum()/reviews.size();
    }


    public List<Review> getReviews() {
        return this.reviews;
    }


    public Review getReview(int id) {

        Review aReview = reviews.stream()
                .filter(review -> id == review.getId())
                .findAny()
                .orElse(null);

        return aReview;
    }


    public Review getReviewByPlatform(String platform) {
        Review aReview = reviews.stream()
                .filter(review -> platform.equals(review.getPlatformOrigin()))
                .findAny()
                .orElse(null);

        return aReview;
    }


    public ArrayList<Review> getReviewsByPlatform(String platform) {
        ArrayList<Review> aReviews = reviews.stream()
                .filter(review -> review.getPlatformOrigin()==platform)
                .collect(Collectors.toCollection(ArrayList::new));
        return aReviews;
    }

/*
    public ArrayList<Review> getReviewsByContainSpoiler(boolean containSpoiler) {
        ArrayList<Review> aReviews = reviews.stream()
                .filter(review -> review.getContainsSpoilers()==containSpoiler)
                .collect(Collectors.toCollection(ArrayList::new));
        return aReviews;
    }
    */


    public ArrayList<Review> getReviewsByLanguage(String language) {
        ArrayList<Review> aReviews = reviews.stream()
                .filter(review -> review.getLanguage()==language)
                .collect(Collectors.toCollection(ArrayList::new));
        return aReviews;
    }

  /*
    public ArrayList<PublicReview> getReviewsByGeoLocation(String geolocation) {
        ArrayList<PublicReview> aReviews = reviews.stream()
                .filter(review -> review.getGeolocation()==geolocation)
                .collect(Collectors.toCollection(ArrayList::new));
        return aReviews;
    }
*/
    public ArrayList<Review> getReviewsByType(String type) {
        ArrayList<Review> aReviews = reviews.stream()
                .filter(review -> review.getType()==type)
                .collect(Collectors.toCollection(ArrayList::new));
        return aReviews;
    }


    public ArrayList<Review> getReviewsLikes() {
        ArrayList<Review> aReviews = reviews.stream()
                .filter(review -> review.getLikes()>=1)
                .collect(Collectors.toCollection(ArrayList::new));
        return aReviews;
    }


    public ArrayList<Review> getReviewsDislikes() {
        ArrayList<Review> aReviews = reviews.stream()
                .filter(review -> review.getDislikes()>=1)
                .collect(Collectors.toCollection(ArrayList::new));
        return aReviews;
    }


    public ArrayList<Review> getReviewsOrderByLikes() {
        ArrayList<Review> aReviews = reviews.stream()
                .sorted(Comparator.comparingInt(Review::getLikes).reversed())
                .collect(Collectors.toCollection(ArrayList::new));
        return aReviews;
    }


    public void reportReview(Integer idReview) {
        if( reviews.contains(getReview(idReview))){
            reviews.remove(getReview(idReview));
        }
    }


    public boolean hasSomeReviewWithMoreStarThan(Integer reviewStar) {

        return reviews.stream()
                .anyMatch(review -> review.getRating()>=reviewStar);

    }

}
