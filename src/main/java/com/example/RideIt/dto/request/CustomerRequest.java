package com.example.RideIt.dto.request;

import com.example.RideIt.ENUM.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CustomerRequest {

    String name;

    int age;

    String email;

    String address;


    Gender gender;
}
