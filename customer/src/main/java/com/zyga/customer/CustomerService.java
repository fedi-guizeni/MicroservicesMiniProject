package com.zyga.customer;

import com.zyga.fraudClient.FraudCheckResponse;
import com.zyga.fraudClient.FraudClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(CustomerRepo customerRepo,
                              RestTemplate restTemplate,
                              FraudClient fraudClient) {
    public void regiseterCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        customerRepo.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraud(customer.getId());

        //assert fraudCheckResponse != null : "fraud null";
        if (fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("fraudter");
        }
        customerRepo.save(customer);
    }

}
