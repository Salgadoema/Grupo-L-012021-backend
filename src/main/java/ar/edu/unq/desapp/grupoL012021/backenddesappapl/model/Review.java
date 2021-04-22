package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

    @OneToMany
    private List<Report> reports;

}
