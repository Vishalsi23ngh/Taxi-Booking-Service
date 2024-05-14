package com.example.RideIt.controller;

import com.example.RideIt.ENUM.Gender;
import com.example.RideIt.dto.request.CustomerRequest;
import com.example.RideIt.dto.response.CustomerResponse;
import com.example.RideIt.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

//    @Autowired
//    CustomerService customerService;

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> addCustomer(@RequestBody CustomerRequest customerRequest){
        CustomerResponse response = customerService.addCustomer(customerRequest);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }


    // get customer of the particular gender and particular age
    @GetMapping("/gender/{gender}/age/{age}")
    public ResponseEntity<List<CustomerResponse>> getCustomerByGenderAndAgeGreaterThan(@PathVariable("gender") Gender gender, @PathVariable("age") int age){
        List<CustomerResponse> customerResponses =  customerService.getCustomerByGenderAndAgeGreaterThan(gender,age);
        return new ResponseEntity<>(customerResponses,HttpStatus.FOUND);
    }

}
