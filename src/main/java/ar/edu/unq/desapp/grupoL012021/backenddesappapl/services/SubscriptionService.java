package ar.edu.unq.desapp.grupoL012021.backenddesappapl.services;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.dto.SubscriptionToContentDTO;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.dto.SubscriptionUrlDTO;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.NotificationSubscription;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.persistence.SubscriptionPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionPersistence repository;

    @Transactional
    public NotificationSubscription save(SubscriptionUrlDTO subscription) {
        NotificationSubscription newSubscription = new NotificationSubscription();
        newSubscription.setListeningUrl(subscription.getNewUrlToNotify());
        return repository.save(newSubscription);
    }

    @Transactional
    public NotificationSubscription save(NotificationSubscription subscription) {
        return repository.save(subscription);
    }

    @Transactional
    public NotificationSubscription add(SubscriptionToContentDTO newSubscriptionDTO) {
        Optional<NotificationSubscription> subscriptionToUpdate = repository.findById(newSubscriptionDTO.getSubscriptionId());
        if(subscriptionToUpdate.isPresent()) {
            NotificationSubscription subscription = subscriptionToUpdate.get();
            subscription.addContentId(newSubscriptionDTO.getContentId());
            return repository.save(subscription);
        }
        return null;
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
