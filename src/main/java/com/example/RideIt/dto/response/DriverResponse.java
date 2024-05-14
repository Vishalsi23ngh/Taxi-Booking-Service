package com.example.RideIt.dto.response;

import com.example.RideIt.dto.request.CabRequest;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class DriverResponse {
    String name;

    int age;

    double rating;

    String  email;

    String mobileNumber;

    CabResponse cabResponse;
}
