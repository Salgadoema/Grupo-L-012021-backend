package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class PremiumReview extends Review {

    public PremiumReview() {
        super();
    }

    public PremiumReview(String id, Double rating, String preview, String fullReview, Date dateOfPublish,
                         String platformOrigin, String usernameOnPlatform, String language,
                         String geolocation, Boolean containsSpoilers) {

        super(id, rating, preview, fullReview, dateOfPublish, platformOrigin, usernameOnPlatform, language);
    }
}