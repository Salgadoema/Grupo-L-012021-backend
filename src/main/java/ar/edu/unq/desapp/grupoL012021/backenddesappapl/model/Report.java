package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model;

import javax.persistence.*;

@Entity
public class Report {

    @Id
    @Column
    private String id;

    @Column
    private String type;

    @Column
    private String reporter;

    @ManyToOne
    @JoinColumn(name="review_id")
    private Review review;


    public Report() {
        super();
    }

    public Report(String id, String type, String reporter, Review review) {
        this.id = id;
        this.type = type;
        this.reporter = reporter;
        this.review = review;
    }
}
