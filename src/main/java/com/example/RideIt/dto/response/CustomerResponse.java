package com.example.RideIt.dto.response;

import com.example.RideIt.ENUM.Gender;
import com.example.RideIt.model.Customer;
import com.example.RideIt.model.TripBooking;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomerResponse {
    String name;

    String email;

    int age;

    String address;

    Gender gender;

    @OneToMany
    List<TripBooking> booking = new ArrayList<>();
}

