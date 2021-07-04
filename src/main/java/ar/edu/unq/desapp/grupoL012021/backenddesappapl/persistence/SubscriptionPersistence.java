package ar.edu.unq.desapp.grupoL012021.backenddesappapl.persistence;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.NotificationSubscription;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Configuration
@Repository
public interface SubscriptionPersistence extends JpaRepository<NotificationSubscription, Integer> {

    List<NotificationSubscription> findAllByContentIdsIs(Integer contentId);


}
