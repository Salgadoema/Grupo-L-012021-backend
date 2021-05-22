package ar.edu.unq.desapp.grupoL012021.backenddesappapl.webservices.dto;

public class ReverseSearchDTO {

    private String contentType = null;

    private String contentStartYear = null;

    private String contentEndYear = null;

    private String crewMemberName = null;

    private Integer totalScore = null;

    private Boolean onlyLikedReviews = null;

    public ReverseSearchDTO() { super(); }

    public ReverseSearchDTO( String contentType, String contentStartYear, String contentEndYear,
                             String crewMemberName, Integer totalScore, Boolean onlyLikedReviews) {

        this.contentType = contentType;
        this.contentStartYear = contentStartYear;
        this.contentEndYear = contentEndYear;
        this.crewMemberName = crewMemberName;
        this.totalScore = totalScore;
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

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Boolean getOnlyLikedReviews() {
        return onlyLikedReviews;
    }

    public void setOnlyLikedReviews(Boolean onlyLikedReviews) {
        this.onlyLikedReviews = onlyLikedReviews;
    }
}
