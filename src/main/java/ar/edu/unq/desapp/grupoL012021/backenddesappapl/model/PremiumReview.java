package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("premium")
public class PremiumReview extends Review {

    public PremiumReview() {
        super();
    }

    @Override
    public String getlocation() {
        return null;
    }



    public PremiumReview(String id, String type, Double rating, String preview, String fullReview, Date dateOfPublish,
                         String platformOrigin, String usernameOnPlatform, String language,
                         String geolocation, Boolean containsSpoilers, Integer like, Integer dislike,
                         Reviewable reviewable) {

        super(id, "Premium Review",rating, preview, fullReview, dateOfPublish,
                platformOrigin, usernameOnPlatform, language, containsSpoilers,0,0, reviewable);
    }
}
