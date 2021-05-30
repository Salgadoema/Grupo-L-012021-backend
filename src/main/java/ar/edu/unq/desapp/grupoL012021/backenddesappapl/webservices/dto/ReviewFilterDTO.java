package ar.edu.unq.desapp.grupoL012021.backenddesappapl.webservices.dto;

public class ReviewFilterDTO {

    private String contentName = null;

    private Integer contentId = null;

    private String type = null;

    private String platform = null;

    private Boolean containsSpoilers = null;

    private String language = null;

    private String country = null;

    private String orderBy = "id";

    private Boolean descending = true;

    private Integer pageNumber = 0;

    private Integer pageSize = 10;

    public ReviewFilterDTO() { super(); }

    public ReviewFilterDTO(String type, String platform, Boolean containsSpoilers, String language,
                           String country, String orderBy, Boolean descending, Integer contentId,
                           String contentName, Integer pageNumber, Integer pageSize) {
        this.contentId = contentId;
        this.contentName = contentName;
        this.type = type;
        this.platform = platform;
        this.containsSpoilers = containsSpoilers;
        this.language = language;
        this.country = country;
        this.orderBy = orderBy;
        this.descending = descending;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public String getContentName() {
        return contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
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

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Boolean getContainsSpoilers() {
        return containsSpoilers;
    }

    public void setContainsSpoilers(Boolean containsSpoilers) {
        this.containsSpoilers = containsSpoilers;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Boolean getDescending() {
        return descending;
    }

    public void setDescending(Boolean descending) {
        this.descending = descending;
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

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
