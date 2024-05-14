package com.example.RideIt.transformer;

import com.example.RideIt.dto.request.CustomerRequest;
import com.example.RideIt.dto.response.CustomerResponse;
import com.example.RideIt.model.Customer;

public class CustomerTransformer {

    public static Customer customerRequestToCustomer(CustomerRequest customerRequest){
        return Customer.builder()
                .name(customerRequest.getName())
                .age(customerRequest.getAge())
                .emailId(customerRequest.getEmail())
                .address(customerRequest.getAddress())
                .gender(customerRequest.getGender())

                .build();
    }

    public  static CustomerResponse customerToCustomerResponse(Customer customer){
        return CustomerResponse.builder()
                .name(customer.getName())
                .email(customer.getEmailId())
                .age((customer.getAge()))
                .address(customer.getAddress())
                .booking(customer.getBooking())
                .gender(customer.getGender())
                .build();
    }


}
