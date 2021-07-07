package ar.edu.unq.desapp.grupoL012021.backenddesappapl.dto;

public class SubscriptionUrlDTO {

    public String newUrlToNotify;

    public SubscriptionUrlDTO() { super(); }

    public SubscriptionUrlDTO(String url) {
        this.newUrlToNotify = url;
    }

    public String getNewUrlToNotify() {
        return newUrlToNotify;
    }

    public void setNewUrlToNotify(String newUrlToNotify) {
        this.newUrlToNotify = newUrlToNotify;
    }
}
