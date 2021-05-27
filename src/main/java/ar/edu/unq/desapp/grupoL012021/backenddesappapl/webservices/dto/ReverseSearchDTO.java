package ar.edu.unq.desapp.grupoL012021.backenddesappapl.webservices.dto;

public class ReverseSearchDTO {

    private String contentType = null;

    private String contentStartYear = null;

    private String contentEndYear = null;

    private String crewMemberName = null;

    private Double rating = null;

    private Boolean onlyLikedReviews = null;

    public ReverseSearchDTO() { super(); }

    public ReverseSearchDTO( String contentType, String contentStartYear, String contentEndYear,
                             String crewMemberName, Double rating, Boolean onlyLikedReviews) {

        this.contentType = contentType;
        this.contentStartYear = contentStartYear;
        this.contentEndYear = contentEndYear;
        this.crewMemberName = crewMemberName;
        this.rating = rating;
        this.onlyLikedReviews = onlyLikedReviews;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentStartYear() {
        return contentStartYear;
    }

    public void setContentStartYear(String contentStartYear) {
        this.contentStartYear = contentStartYear;
    }

    public String getContentEndYear() {
        return contentEndYear;
    }

    public void setContentEndYear(String contentEndYear) {
        this.contentEndYear = contentEndYear;
    }

    public String getCrewMemberName() {
        return crewMemberName;
    }

    public void setCrewMemberName(String crewMemberName) {
        this.crewMemberName = crewMemberName;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double totalScore) {
        this.rating = totalScore;
    }

    public Boolean getOnlyLikedReviews() {
        return onlyLikedReviews;
    }

    public void setOnlyLikedReviews(Boolean onlyLikedReviews) {
        this.onlyLikedReviews = onlyLikedReviews;
    }
}
