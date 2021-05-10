package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("Premium")
public class PremiumReview extends Review {

    public PremiumReview() {
        super();
    }

    public PremiumReview(Integer id, String type, Double rating, String preview, String fullReview, Date dateOfPublish,
                         String platformOrigin, String usernameOnPlatform, String language,
                         String geolocation, Boolean containsSpoilers, Integer like, Integer dislike,
                         Content content) {

        super(id, "Premium",rating, preview, fullReview, dateOfPublish,
                platformOrigin, usernameOnPlatform, language, containsSpoilers,0,0, content);
    }

    @Override
    public String getlocation() {
        return null;
    }
}
