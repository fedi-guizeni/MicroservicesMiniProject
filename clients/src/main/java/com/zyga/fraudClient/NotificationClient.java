package com.zyga.fraudClient;

import com.zyga.fraudClient.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient("NOTIFICATION")
public interface NotificationClient {
    @PostMapping("api/v1/notification")
    void sendNotification(NotificationRequest notificationRequest);
}
