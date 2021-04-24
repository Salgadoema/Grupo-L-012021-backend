package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity
public class PublicReview extends Review {

    @Column
    private String geolocation;

    @Column
    private Boolean containsSpoilers;

    public PublicReview() { super(); }



    public PublicReview(String id, String type, Double rating, String preview, String fullReview, Date dateOfPublish,
                        String platformOrigin, String usernameOnPlatform, String language,
                        String geolocation, Boolean containsSpoilers) {

        super(id, "Public Review", rating, preview, fullReview, dateOfPublish, platformOrigin,
                usernameOnPlatform, language, containsSpoilers);

        this.geolocation = geolocation;
        this.containsSpoilers = containsSpoilers;
    }


    public void setgeoLocation(String geoLocation) {
        this.geolocation=geoLocation;
    }
    public String getlocation(){
        return this.geolocation;
    }
}
