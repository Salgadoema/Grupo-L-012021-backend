package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorValue("Series")
public class Series extends Content {

    @Column
    private Integer endYear;

    public Series() {
        super();
    }

    public Series(Integer    id, String titleType, String seriesPrimaryTitle, String originalTitle,
                  Integer startYear, List<Genre> genres, List<CrewMember> crewMembers, List<Review> reviews,
                  Integer endYear) {
        super(id, "Series", seriesPrimaryTitle, originalTitle, startYear, genres, crewMembers, reviews);

        this.endYear = endYear;

    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }
}
