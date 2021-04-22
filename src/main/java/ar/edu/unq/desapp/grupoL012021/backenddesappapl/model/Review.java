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

    public Review() {
        super();
    }

    public Review(String id, Double rating, String preview, String fullReview, Date dateOfPublish,
                  String platformOrigin, String usernameOnPlatform, String language) {

        this.id = id;
        this.rating = rating;
        this.preview = preview;
        this.fullReview = fullReview;
        this.dateOfPublish = dateOfPublish;
        this.platformOrigin = platformOrigin;
        this.usernameOnPlatform = usernameOnPlatform;
        this.language = language;
        this.reports = new ArrayList<Report>();
    }

}
