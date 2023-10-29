package com.zyga.fraudClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("FRAUD")
public interface FraudClient {
    @GetMapping(path = "api/v1/check/{cutomerID}")
      public  FraudCheckResponse isFraud(
            @PathVariable("cutomerID") Integer customerId) ;
}
