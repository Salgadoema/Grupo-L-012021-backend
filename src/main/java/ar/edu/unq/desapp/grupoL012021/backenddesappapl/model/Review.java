package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
public abstract class Review {

    @Id
    @Column
    private String id;

    @Column
    private Double rating;

    @Column
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
   private int like;

    @Column
    private int dislike;

    @OneToMany
    private List<Report> reports;

    public Review() {
        super();
    }

    public Review(String id, String type,Double rating, String preview, String fullReview, Date dateOfPublish,
                  String platformOrigin, String usernameOnPlatform, String language, Boolean containsSpoiler,
                  Integer like, Integer dislike) {

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
        this.like=0;
        this.dislike=0;
    }

    public void setRating(Double rating){
        this.rating=rating;
    }

    public Double getRating() {
        return this.rating;
    }

    public  String getId(){
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

    public String getType(){
        return this.type;
    }

    public  void setType(String type){
        this.type=type;
    }

    public  void addLike(){
        this.like=like+1;
    }
    public  void addDislike(){
        this.dislike=dislike+1;
    }

    public int getlike(){
        return like;
    }

    public int getdislike(){
        return dislike;
    }

}
