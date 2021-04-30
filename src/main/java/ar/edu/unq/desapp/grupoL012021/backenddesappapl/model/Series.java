package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("series")
public class Series extends Reviewable {

    @Column
    private Date endYear;

    public Series() {
        super();
    }









}
