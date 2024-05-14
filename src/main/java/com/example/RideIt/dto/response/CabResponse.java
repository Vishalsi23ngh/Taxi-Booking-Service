package com.example.RideIt.dto.response;

import com.example.RideIt.ENUM.CarType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CabResponse {
    String company;

    String carModel;

    CarType carType;

    int noOfSeats;

    double farePerKm;

    String cabNo;
}
