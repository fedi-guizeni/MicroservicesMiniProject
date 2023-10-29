package com.zyga.fraudClient;

public record FraudCheckResponse(
        Integer cutomerId,
                                  Boolean isFraudster) {
}
