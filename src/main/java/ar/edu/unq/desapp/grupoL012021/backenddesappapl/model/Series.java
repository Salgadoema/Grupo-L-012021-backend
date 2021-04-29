package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.stream.Collectors;

@Entity
public class Series extends Reviewable {

    @Column
    private Date endYear;

    public Series() {
        super();
    }









}
