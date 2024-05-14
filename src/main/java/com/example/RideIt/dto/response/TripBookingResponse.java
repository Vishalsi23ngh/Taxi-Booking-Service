package com.example.RideIt.dto.response;

import com.example.RideIt.ENUM.TripStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level =  AccessLevel.PRIVATE)
@Builder
public class TripBookingResponse {
    String bookingId;

    String pickUp;

    String destination;

    double tripDistanceInKm;

    double totalFare;

    TripStatus tripStatus;

    Date bookedAt;

    CustomerResponse customerResponse;

    DriverResponse driverResponse;
}
