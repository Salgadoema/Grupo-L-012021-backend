package ar.edu.unq.desapp.grupoL012021.backenddesappapl.notification;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.config.RabbitMQConfig;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.NotificationSubscription;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.services.SubscriptionService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Component
public class Notifier {

    @Autowired
    private SubscriptionService service;

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void consumeMessage(Integer contentId) {
        Integer idToNotify = contentId;
        List<NotificationSubscription> subs = service.findAll(idToNotify);

        subs.forEach((sub) -> System.out.println("Now notifying : " +sub.getListeningUrl()));

        subs.forEach((sub) -> sendNotification(sub.getListeningUrl()));
    }

    private void sendNotification(String subscriptionUrl) {
        try {
            URL url = new URL(subscriptionUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int status = con.getResponseCode();
            Reader streamReader = null;
            System.out.println(status);
            con.disconnect();
        }catch(Exception e){
            System.out.println("There was a problem with the notification.");
        }
    }
}
