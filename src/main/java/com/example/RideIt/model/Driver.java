package com.example.RideIt.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Driver")
@Builder
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    int age;

    String panNumber;

    double rating;

    @Column(unique = true ,nullable = false)
    String  email;

    @Column(unique = true , nullable = false)
    String mobileNumber;

    @OneToOne(mappedBy = "driver" ,cascade = CascadeType.ALL)
    Cab cab;

    @OneToMany(mappedBy = "driver",cascade = CascadeType.ALL)
    List<TripBooking> bookings = new ArrayList<>();
}
