package ar.edu.unq.desapp.grupoL012021.backenddesappapl.webservices.dto;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Movie;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.PublicReview;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Report;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReviewDTO {

    public Double rating = 0.0;

    public String preview = "";

    public String fullReview = "";

    public Date date = null;

    public String username = "";

    public String platform = "";

    public String language = "";

    public String geolocation = "";

    public Boolean containsSpoilers = null;

    public Integer likes = 0;

    public Integer dislikes = 0;

    public List<Report> reports = new ArrayList<Report>();

    public Integer contentId = null;

    public ReviewDTO() { super(); }

    public ReviewDTO( Double rating, String preview, String fullReview,
                      Date date, String username, String platform, String language, String geolocation,
                      Boolean containsSpoilers, Integer contentId) {

        this.rating = rating;
        this.preview = preview;
        this.fullReview = fullReview;
        this.date = date;
        this.username = username;
        this.platform = platform;
        this.language = language;
        this.geolocation = geolocation;
        this.containsSpoilers = containsSpoilers;
        this.contentId = contentId;
    }

    public PublicReview modelPublic(Movie movie) {

        PublicReview model = new PublicReview();
        model.setType("Public");
        model.setRating(rating);
        model.setPreview(preview);
        model.setFullReview(fullReview);
        model.setDateOfPublish(date);
        model.setUsernameOnPlatform(username);
        model.setPlatform(platform);
        model.setLanguage(language);
        model.setGeolocation(geolocation);
        model.setContainsSpoilers(containsSpoilers);
        model.setReports(reports);
        model.setContent(movie);

        return model;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getFullReview() {
        return fullReview;
    }

    public void setFullReview(String fullReview) {
        this.fullReview = fullReview;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Boolean getContainsSpoilers() {
        return containsSpoilers;
    }

    public void setContainsSpoilers(Boolean containsSpoilers) {
        this.containsSpoilers = containsSpoilers;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getDislikes() {
        return dislikes;
    }

    public void setDislikes(Integer dislikes) {
        this.dislikes = dislikes;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }
}
