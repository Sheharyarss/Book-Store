package com.example.demo.controller;


import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.CustomerDto;
import com.example.demo.model.Customer;
import com.example.demo.service.CategoryService;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerService customerService;



    @PostMapping("/customer")
    public ResponseEntity<CustomerDto> postCustomer(@RequestBody CustomerDto customerDto) {
        return ResponseEntity.ok(customerService.postCustomer(customerDto));
    }

    @GetMapping("/customer")
    public ResponseEntity<List<CustomerDto>> getAllCustomer(){
        return  ResponseEntity.ok(customerService.getAllCustomer());
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long id){
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @PutMapping("/customer/{id}")
    public  ResponseEntity<CustomerDto> updateCustomerById(@PathVariable Long id , @RequestBody CustomerDto customerDto){
        return ResponseEntity.ok(customerService.updateCustomerById(id,customerDto));
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable Long id) {

        customerService.deleteCustomerById(id);
        return ResponseEntity.ok().build();

    }

}
