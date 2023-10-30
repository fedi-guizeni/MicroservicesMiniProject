package com.zyga.notification;

import lombok.AllArgsConstructor;
import com.zyga.fraudClient.NotificationRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepo notificationRepo ;
    public void send(NotificationRequest notificationRequest) {
        notificationRepo.save(
                Notification.builder()
                        .toCustoemerId(notificationRequest.toCustomerId())
                        .toCustomerEmail(notificationRequest.toCustomerName())
                        .sender("Fedi guizani")
                        .message(notificationRequest.message())
                        .sentAt(LocalDateTime.now())
                        .build()
        );
    }
}
