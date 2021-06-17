package ar.edu.unq.desapp.grupoL012021.backenddesappapl.services.dto;

public class ReverseSearchDTO {

    private String contentType = null;

    private String contentStartYear = null;

    private String contentEndYear = null;

    private String crewMemberName = null;

    private String genre = null;

    private Double rating = null;

    private Boolean onlyLikedReviews = null;

    private Integer pageNumber = 0;

    private Integer pageSize = 5;

    public ReverseSearchDTO() { super(); }

    public ReverseSearchDTO( String contentType, String contentStartYear, String contentEndYear,
                             String crewMemberName, String genreName, Double rating, Boolean onlyLikedReviews,
                             Integer pageNumber, Integer pageSize) {

        this.contentType = contentType;
        this.contentStartYear = contentStartYear;
        this.contentEndYear = contentEndYear;
        this.crewMemberName = crewMemberName;
        this.genre = genreName;
        this.rating = rating;
        this.onlyLikedReviews = onlyLikedReviews;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
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

    public String getGenre() { return genre; }

    public void setGenre(String genreName) { this.genre = genreName; }

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

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageQuantity) {
        this.pageSize = pageQuantity;
    }
}
