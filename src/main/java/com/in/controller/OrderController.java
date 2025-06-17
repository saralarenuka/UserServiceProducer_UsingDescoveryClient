package com.in.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/place")
    public String placeOrder() {
        // Get list of instances registered under "user-service"
        List<ServiceInstance> instances = discoveryClient.getInstances("USER-SERVICE");
        ServiceInstance si = (ServiceInstance) instances.get(0);  //host,post,IP
        String url = si.getUri()+"/user/show";
        RestTemplate rt = new RestTemplate();
        String response = rt.getForObject(url, String.class);
        return response;   
    
    }
}
