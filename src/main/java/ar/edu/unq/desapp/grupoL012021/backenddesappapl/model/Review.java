package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column
    private Date dateOfPublish;

    @Column
    private String platformOrigin;

    @Column
    private String usernameOnPlatform;

    @Column
    private String language;

    @Column
    private int likes;

    @Column
    private int dislikes;

    @JsonManagedReference
    @OneToMany(mappedBy = "review", fetch = FetchType.LAZY)
    private List<Report> reports;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "content_id", nullable = false)
    private Content content;

    public Review() {
        super();
    }

    public Review(Integer id, String type,Double rating, String preview, String fullReview, Date dateOfPublish,
                  String platformOrigin, String usernameOnPlatform, String language,
                  Integer like, Integer dislike, Content content) {

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
        this.likes=0;
        this.dislikes=0;
        this.content = content;
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

    public  void setLanguage(String language){
        this.language=language;
    }

    public String getLanguage(){
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

    public Content getContent() { return content; }

    public void setContent(Content content) {
        this.content = content;
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

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    public void addReport(Report report) {
        this.reports.add(report);
    }
}
