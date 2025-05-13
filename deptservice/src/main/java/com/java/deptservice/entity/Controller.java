package com.java.deptservice.entity;

import com.java.deptservice.entity.entity.Address;
import com.java.deptservice.entity.entity.Order;
import com.java.deptservice.entity.repository.OrderRepo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/join")
public class Controller {

    private OrderRepo orderRepo;

    @PostMapping
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

    @DeleteMapping("/{id}")
    void deleteData(@PathVariable("id") Long id){
        orderRepo.deleteById(id);
    }

    @GetMapping("/{id}")
    Optional<Order> getData(@PathVariable("id") Long id){
        return orderRepo.findById(id);
    }
}
