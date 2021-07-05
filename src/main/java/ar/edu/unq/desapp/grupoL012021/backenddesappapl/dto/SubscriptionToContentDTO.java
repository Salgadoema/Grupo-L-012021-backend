package ar.edu.unq.desapp.grupoL012021.backenddesappapl.dto;

public class SubscriptionToContentDTO {

    private Integer contentId;

    private Integer subscriptionId;

    public SubscriptionToContentDTO() { super(); }

    public SubscriptionToContentDTO(Integer contentId, Integer subscriptionId) {
        this.contentId = contentId;
        this.subscriptionId = subscriptionId;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public Integer getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Integer subscriptionId) {
        this.subscriptionId = subscriptionId;
    }
}
