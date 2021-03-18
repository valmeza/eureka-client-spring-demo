package com.spring.eurekaclient.controller;

import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

    @Autowired
    public RestTemplate restTemplate;

    @GetMapping("/client-service/{price}")
    public String invokePaymentService(@PathVariable int price) {
        String url = "http://EUREKA-SERVICE-DEMO/api/payment/" + price;

        return restTemplate.getForObject(url, String.class);
    }
}
