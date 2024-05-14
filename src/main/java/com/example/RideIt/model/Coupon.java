package com.example.RideIt.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Coupan")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Coupon {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int id;

    String coupanCode;

    int percentageDiscount;
}
