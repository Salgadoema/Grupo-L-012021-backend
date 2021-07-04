package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class NotificationSubscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(nullable = false)
    private String listeningUrl;

    @ElementCollection
    @CollectionTable(
            name="CONTENT_ID_TABLE",
            joinColumns = @JoinColumn(name="content_id")
    )
    private List<Integer> contentIds;

    public NotificationSubscription() { super(); }

    public NotificationSubscription(Integer id, String listeningUrl) {
        this.id = id;
        this.listeningUrl = listeningUrl;
        this.contentIds = new ArrayList<Integer>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getListeningUrl() {
        return listeningUrl;
    }

    public void setListeningUrl(String listeningUrl) {
        this.listeningUrl = listeningUrl;
    }

    public List<Integer> getContentIds() {
        return contentIds;
    }

    public void setContentIds(List<Integer> contentIds) {
        this.contentIds = contentIds;
    }

    public void addContentId(Integer contentId) {
        this.contentIds.add(contentId);
    }
}
