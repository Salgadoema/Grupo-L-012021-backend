package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PublicReview extends Review {

    @Column
    private String geolocation;

    @Column
    private Boolean containsSpoilers;
}
