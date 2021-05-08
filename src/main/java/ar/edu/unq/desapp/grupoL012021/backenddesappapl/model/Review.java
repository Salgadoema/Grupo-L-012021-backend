package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="review_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private Double rating;

    @Column(name="review_type", insertable = false, updatable = false)
    private String type;

    @Column
    private String preview;

    @Column
    private String fullReview;

    @Column
    private Date dateOfPublish;

    @Column
    private String platformOrigin;

    @Column
    private String usernameOnPlatform;

    @Column
    private String language;

    @Column
    @JsonIgnore
    private Boolean containsSpoiler;

    @Column
    private int likes;

    @Column
    private int dislikes;

    @OneToMany(mappedBy = "review")
    private List<Report> reports;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reviewable_id", nullable = false)
    private Reviewable reviewable;

    public Review() {
        super();
    }

    public Review(Integer id, String type,Double rating, String preview, String fullReview, Date dateOfPublish,
                  String platformOrigin, String usernameOnPlatform, String language, Boolean containsSpoiler,
                  Integer like, Integer dislike, Reviewable reviewable) {

        this.id = id;
        this.type=type;
        this.rating = rating;
        this.preview = preview;
        this.fullReview = fullReview;
        this.dateOfPublish = dateOfPublish;
        this.platformOrigin = platformOrigin;
        this.usernameOnPlatform = usernameOnPlatform;
        this.language = language;
        this.reports = new ArrayList<Report>();
        this.containsSpoiler = containsSpoiler;
        this.likes=0;
        this.dislikes=0;
        this.reviewable=reviewable;
    }

    public void setRating(Double rating){
        this.rating=rating;
    }

    public Double getRating() {
        return this.rating;
    }

    public  Integer getId(){
        return this.id;
    }

    public void setId(Integer id) { this.id = id; }

    public  String getPlatform(){
        return this.platformOrigin;
    }

    public  void setPlatform(String platform){
        this.platformOrigin=platform;
    }

    public  void setContainsSpoiler(Boolean containsSpoiler){
        this.containsSpoiler=containsSpoiler;
    }

    public boolean getContainsSpoiler(){
        return this.containsSpoiler;
    }

    public  void setLanguage(String language){
        this.language=language;
    }

    public String getlanguage(){
        return this.language;
    }

    public abstract String getlocation();

    public String getType(){ return this.type; }

    public  void setType(String type){ this.type=type; }

    public  void addLike(){

        this.likes=likes+1;
    }

    public  void addDislike(){

        this.dislikes=dislikes+1;
    }

    public int getLikes(){
        return likes;
    }

    public void setLikes(int likes) { this.likes = likes;}

    public int getDislikes(){
        return dislikes;
    }

    public void setDislikes() { this.dislikes = dislikes; }

    public Reviewable getReviewable() { return reviewable; }

    public void setReviewable(Reviewable reviewable) {
        this.reviewable = reviewable;
    }

    public String getFullReview() {
        return fullReview;
    }

    public void setFullReview(String fullReview) {
        this.fullReview = fullReview;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public Date getDateOfPublish() {
        return dateOfPublish;
    }

    public void setDateOfPublish(Date dateOfPublish) {
        this.dateOfPublish = dateOfPublish;
    }

    public String getPlatformOrigin() {
        return platformOrigin;
    }

    public void setPlatformOrigin(String platformOrigin) {
        this.platformOrigin = platformOrigin;
    }

    public String getUsernameOnPlatform() {
        return usernameOnPlatform;
    }

    public void setUsernameOnPlatform(String usernameOnPlatform) {
        this.usernameOnPlatform = usernameOnPlatform;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

}
