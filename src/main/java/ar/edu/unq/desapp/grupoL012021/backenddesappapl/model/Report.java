package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Report {

    @Id
    @Column
    private String id;

    @Column
    private String type;

    @Column
    private String reporter;

    public Report() {
        super();
    }

    public Report(String id, String type, String reporter) {
        this.id = id;
        this.type = type;
        this.reporter = reporter;
    }
}
