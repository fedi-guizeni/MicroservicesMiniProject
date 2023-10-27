package com.zyga.customer;

import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepo customerRepo) {
    public void regiseterCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        customerRepo.save(customer);
    }

}
