package com.example.RideIt.model;


import com.example.RideIt.ENUM.TripStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TripBooking")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class TripBooking {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int id;

    String bookingId;

    String pickUp;

    String destination;

    double tripDistanceInKm;

    double totalFare;

    TripStatus tripStatus;

    @CreationTimestamp
    Date bookedAt;

    @ManyToOne
    @JoinColumn
    Customer customer;

    @ManyToOne
    @JoinColumn
    Driver driver;
}

