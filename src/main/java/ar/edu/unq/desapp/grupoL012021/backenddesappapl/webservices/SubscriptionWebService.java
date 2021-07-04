package ar.edu.unq.desapp.grupoL012021.backenddesappapl.webservices;

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
    public ResponseEntity<NotificationSubscription> addNotificationSubscription(@RequestBody String url) {
        NotificationSubscription subscription = subscriptionService.save(url);
        if (subscription == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(subscription);
        }
    }

    @PostMapping("/api/subscription/{idSubscription}")
    public ResponseEntity<NotificationSubscription> addNotificationFromContent(@PathVariable Integer idSubscription, @RequestParam Integer contentId) {
        NotificationSubscription subscription = subscriptionService.find(idSubscription);
        if (subscription == null) {
            return ResponseEntity.notFound().build();
        } else {
            subscription.addContentId(contentId);
            return ResponseEntity.ok(subscriptionService.save(subscription));
        }
    }

    @GetMapping("/api/subscription/{contentId}")
    public ResponseEntity<List<NotificationSubscription>> getContentNotificationSubscribers(@PathVariable Integer contentId) {
        List<NotificationSubscription> subscriptions = subscriptionService.findAll(contentId);
        return ResponseEntity.ok(subscriptions);
    }

}
