package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("Public")
public class PublicReview extends Review {

    @Column
    private String geolocation;

    @Column
    private Boolean containsSpoilers;

    public PublicReview() { super(); }

    public PublicReview(Integer id, Double rating, String preview, String fullReview, Date dateOfPublish,
                        String platformOrigin, String usernameOnPlatform, String language,
                        String geolocation, Boolean containsSpoilers, Integer likes, Integer dislikes,
                        Content content) {

        super(id, "Public", rating, preview, fullReview, dateOfPublish, platformOrigin,
                usernameOnPlatform, language,0,0, content);

        this.geolocation = geolocation;
        this.containsSpoilers = containsSpoilers;
    }


    public void setGeolocation(String geoLocation) {
        this.geolocation=geoLocation;
    }

    public String getGeolocation() { return this.geolocation; }

    public String getlocation() { return this.getGeolocation(); }

    public Boolean getContainsSpoilers() {
        return containsSpoilers;
    }

    public void setContainsSpoilers(Boolean containsSpoilers) {
        this.containsSpoilers = containsSpoilers;
    }
}
