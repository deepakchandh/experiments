package com.java.deptservice.entity;

import com.java.deptservice.entity.entity.Address;
import com.java.deptservice.entity.entity.Order;
import com.java.deptservice.entity.repository.OrderRepo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@AllArgsConstructor
public class Controller {

    private OrderRepo orderRepo;


    @PostMapping("save")
    void saveData(){
        Order orderyy = new Order();
        orderyy.setOrderTrackingNumber("100ac");
        orderyy.setTotalQuantity(5);
        orderyy.setStatus("IN_PROGRESS");
        orderyy.setTotalPrice(new BigDecimal("100"));

        Address address = new Address();
        address.setCity("Pune");
        address.setState("MH");
        address.setStreet("whale");
        address.setCountry("India");
        address.setZipCode("651101");

        orderyy.setBillingAddress(address);
        orderRepo.save(orderyy);

    }
}
