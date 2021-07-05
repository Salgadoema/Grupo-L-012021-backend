package ar.edu.unq.desapp.grupoL012021.backenddesappapl.webservices;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.dto.SubscriptionToContentDTO;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.dto.SubscriptionUrlDTO;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.NotificationSubscription;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class SubscriptionWebService {

    @Autowired
    public SubscriptionService subscriptionService;

    @PostMapping("/api/subscription/new")
    public ResponseEntity<NotificationSubscription> addNotificationSubscription(@RequestBody SubscriptionUrlDTO subscriptionUrlDTO) {
        NotificationSubscription subscription = subscriptionService.save(subscriptionUrlDTO);
        if (subscription == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(subscription);
        }
    }

    @PostMapping("/api/subscription")
    public ResponseEntity<NotificationSubscription> addNotificationFromContent(@RequestBody SubscriptionToContentDTO subscriptionToContentDTO) {
        NotificationSubscription subscription = subscriptionService.add(subscriptionToContentDTO);
        if (subscription == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(subscription);
        }
    }

    @GetMapping("/api/subscription/{contentId}")
    public ResponseEntity<List<NotificationSubscription>> getContentNotificationSubscribers(@PathVariable Integer contentId) {
        List<NotificationSubscription> subscriptions = subscriptionService.findAll(contentId);
        return ResponseEntity.ok(subscriptions);
    }

}
