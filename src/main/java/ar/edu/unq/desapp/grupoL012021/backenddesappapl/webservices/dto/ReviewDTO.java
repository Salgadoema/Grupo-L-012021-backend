package ar.edu.unq.desapp.grupoL012021.backenddesappapl.webservices.dto;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Movie;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.PremiumReview;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.PublicReview;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Report;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReviewDTO {

    private String type;

    private Double rating = null;

    private String preview = null;

    private String fullReview = null;

    private Date date = null;

    private String username = null;

    private String platform = null;

    private String language = null;

    private String geolocation = null;

    private Boolean containsSpoilers = null;

    private Integer likes = null;

    private Integer dislikes = null;

    private List<Report> reports = null;

    private Integer contentId = null;

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
        model.setPlatformOrigin(platform);
        model.setLanguage(language);
        model.setGeolocation(geolocation);
        model.setContainsSpoilers(containsSpoilers);
        model.setContent(movie);
        model.setReports(new ArrayList<Report>());
        model.setLikes(0);
        model.setDislikes(0);

        return model;
    }

    public PublicReview modelPublic() {
        PublicReview model = new PublicReview();
        model.setType(type);
        model.setRating(rating);
        model.setPreview(preview);
        model.setFullReview(fullReview);
        model.setDateOfPublish(date);
        model.setUsernameOnPlatform(username);
        model.setPlatformOrigin(platform);
        model.setLanguage(language);
        model.setGeolocation(geolocation);
        model.setContainsSpoilers(containsSpoilers);
        model.setReports(reports);
        //model.setLikes(likes);
        //model.setDislikes(dislikes);

        return model;
    }

    public PremiumReview modelPremium() {
        PremiumReview model = new PremiumReview();
        model.setType(type);
        model.setRating(rating);
        model.setPreview(preview);
        model.setFullReview(fullReview);
        model.setDateOfPublish(date);
        model.setUsernameOnPlatform(username);
        model.setPlatformOrigin(platform);
        model.setLanguage(language);
        model.setReports(reports);
        //model.setLikes(likes);
        //model.setDislikes(dislikes);

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(String geolocation) {
        this.geolocation = geolocation;
    }
}
