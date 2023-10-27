package com.zyga.fraud;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/check")
public record FraudController(FraudService fraudService) {

    @GetMapping(path = "{cutomerID}")
    public FraudCheckResponse isFraud(
            @PathVariable("customerId") Integer customerId) {
       boolean isFraudulentCustomer = fraudService.isFraudulentCustomer(customerId);
        return new FraudCheckResponse(customerId , isFraudulentCustomer);

    }
}
