package com.zyga.fraud;

import com.zyga.fraudClient.FraudCheckResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/check")
@Slf4j
public record FraudController(FraudService fraudService) {

    @GetMapping(path = "{cutomerID}")
    public FraudCheckResponse isFraud(
            @PathVariable("cutomerID") Integer customerId) {
       boolean isFraudulentCustomer = fraudService.isFraudulentCustomer(customerId);
       log.info("fraud check request for customer {}", customerId );
        return new FraudCheckResponse(customerId , isFraudulentCustomer);

    }
}
