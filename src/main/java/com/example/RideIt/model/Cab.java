package com.example.RideIt.model;

import com.example.RideIt.ENUM.CarType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Cab")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Cab {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int id;

    @Column(unique = true,nullable = false)
    String cabNo;

    String company;

    String carModel;

    @Enumerated(value = EnumType.STRING)
    CarType carType;

    int noOfSeats;

    boolean available;

    double farePerKm;

    @OneToOne
    @JoinColumn
    Driver driver;

}
