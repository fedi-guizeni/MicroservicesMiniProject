package com.zyga.notification.rabbitMq;

import com.zyga.fraudClient.NotificationRequest;
import com.zyga.notification.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class NotificationConsumer {
    private  final NotificationService notificationService ;


    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public  void consumer(NotificationRequest notificationRequest){
        log.info("consumed {} from quene",notificationRequest);
        notificationService.send(notificationRequest);
    }
}
