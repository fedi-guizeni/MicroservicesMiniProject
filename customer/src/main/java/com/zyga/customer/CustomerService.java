package com.zyga.customer;

import com.zyga.amqp.RabbitMQMessageProducer;
import com.zyga.fraudClient.FraudCheckResponse;
import com.zyga.fraudClient.FraudClient;
import com.zyga.fraudClient.NotificationClient;
import com.zyga.fraudClient.NotificationRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(CustomerRepo customerRepo,
                              RestTemplate restTemplate,
                              FraudClient fraudClient ,
                              NotificationClient notificationClient,
                              RabbitMQMessageProducer producer) {
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
        NotificationRequest notificationRequest =  new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Hi %s, welcome to zygaGym...",
                        customer.getFirstName())
        );

        producer.publish(notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key");
    }

}
