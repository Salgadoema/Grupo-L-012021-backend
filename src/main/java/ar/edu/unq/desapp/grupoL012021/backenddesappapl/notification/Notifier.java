package ar.edu.unq.desapp.grupoL012021.backenddesappapl.notification;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Notifier {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void consumeMessage(Integer contentId) {
        Integer idToNotify = contentId;
        System.out.println("Id of content is : " +idToNotify);
        //Aca iria el codigo para notificar a las url que me dan

    }
}
