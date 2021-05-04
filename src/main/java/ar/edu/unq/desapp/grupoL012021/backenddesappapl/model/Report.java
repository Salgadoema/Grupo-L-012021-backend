package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model;

import javax.persistence.*;

@Entity
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

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

    public Report(Integer id, String type, String reporter, Review review) {
        this.id = id;
        this.type = type;
        this.reporter = reporter;
        this.review = review;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }
}
