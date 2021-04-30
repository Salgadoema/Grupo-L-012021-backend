package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("episode")
public class Episode extends Reviewable {

    public Episode() {
        super();
    }



}
