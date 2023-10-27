package com.zyga.fraud;

import java.time.LocalDateTime;

public record FraudCheckResponse(
        Integer cutomerId,
        Boolean isFraudster



) {
}
