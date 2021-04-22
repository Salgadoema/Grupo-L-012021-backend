package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Actor {

    //nconst
    @Id
    @Column
    private String id;

    @Column
    private String name;

    public Actor() {
        super();
    }

    public Actor(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
