package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("public")
public class PublicReview extends Review {

    @Column
    private String geolocation;

    @Column
    private Boolean containsSpoilers;

    public PublicReview() { super(); }

    public PublicReview(Integer id, String type, Double rating, String preview, String fullReview, Date dateOfPublish,
                        String platformOrigin, String usernameOnPlatform, String language,
                        String geolocation, Boolean containsSpoilers, Integer like, Integer dislike,
                        Reviewable reviewable) {

        super(id, "Public", rating, preview, fullReview, dateOfPublish, platformOrigin,
                usernameOnPlatform, language, containsSpoilers,0,0, reviewable);

        this.geolocation = geolocation;
        this.containsSpoilers = containsSpoilers;
    }


    public void setgeoLocation(String geoLocation) {
        this.geolocation=geoLocation;
    }

    public String getlocation(){
        return this.geolocation;
    }

    public Boolean getContainsSpoilers() {
        return containsSpoilers;
    }

    public void setContainsSpoilers(Boolean containsSpoilers) {
        this.containsSpoilers = containsSpoilers;
    }
}
