package ar.edu.unq.desapp.grupoL012021.backenddesappapl.dto;

import javax.persistence.Column;

public class ContentDTO {

    private String primaryTitle;

    private String originalTitle;

    private Double average;

    private Integer reviewsQty;

    public Integer getReviewsQty() {
        return reviewsQty;
    }

    public void setReviewsQty(Integer reviewsQty) {
        this.reviewsQty = reviewsQty;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public String getPrimaryTitle() {
        return primaryTitle;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public void setPrimaryTitle(String primaryTitle) {
        this.primaryTitle = primaryTitle;
    }
}
