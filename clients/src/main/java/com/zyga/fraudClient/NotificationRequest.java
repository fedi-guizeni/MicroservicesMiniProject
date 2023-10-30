package com.zyga.fraudClient;

public record NotificationRequest( Integer toCustomerId,
                                   String toCustomerName,
                                   String message) {
}
