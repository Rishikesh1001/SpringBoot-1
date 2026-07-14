package com.rishikesh.demo.DependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    //    @Autowired //Field injection
    PaymentService paymentService;

    //    @Autowired //constructor injection
    public OrderService(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @Autowired // setter injection
    public void setPaymentService(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    public void placeOrder(){
        paymentService.payment();
        System.out.println("Order Placed");
    }
}