package ar.edu.unq.desapp.grupoL012021.backenddesappapl.services;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.NotificationSubscription;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.persistence.SubscriptionPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionPersistence repository;

    @Transactional
    public NotificationSubscription save(String url) {
        NotificationSubscription newSubscription = new NotificationSubscription();
        newSubscription.setListeningUrl(url);
        return repository.save(newSubscription);
    }

    @Transactional
    public NotificationSubscription save(NotificationSubscription subscription) {
        return repository.save(subscription);
    }

    @Transactional
    public NotificationSubscription find(Integer idSubscription) {
        return repository.findById(idSubscription).get();
    }

    @Transactional
    public List<NotificationSubscription> findAll(Integer contentId) {
        return repository.findAllByContentIdsIs(contentId);
    }
}
