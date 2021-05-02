package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model;

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
    private Boolean containsSpoiler;

    @Column
    private int likes;

    @Column
    private int dislikes;

    @OneToMany(mappedBy = "review")
    private List<Report> reports;

    @ManyToOne
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

    public  String getPlatform(){
        return this.platformOrigin;
    }

    public  void setPlatform(String platform){
        this.platformOrigin=platform;
    }

    public  void setContainSpoiler(Boolean containsSpoiler){
        this.containsSpoiler=containsSpoiler;
    }

    public boolean getContainSpoiler(){
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

    public int getlike(){
        return likes;
    }

    public int getdislike(){
        return dislikes;
    }

    public Reviewable getReviewable() { return reviewable; }

}
