package com.example.RideIt.transformer;

import com.example.RideIt.dto.request.DriverRequest;
import com.example.RideIt.dto.response.DriverResponse;
import com.example.RideIt.model.Driver;

public class DriverTransformer {

    public  static Driver driverRequestToDriver(DriverRequest driverRequest){
        return Driver.builder()
                .name(driverRequest.getName())
                .email(driverRequest.getEmail())
                .age(driverRequest.getAge())
                .panNumber(driverRequest.getPanNumber())
                .mobileNumber(driverRequest.getMobileNumber())
                .rating(0)
                .build();
    }

    public static DriverResponse driverToDriverResponse(Driver driver){
        return DriverResponse.builder()
                    .name(driver.getName())
                    .age(driver.getAge())
                    .email(driver.getEmail())
                    .rating(driver.getRating())
                .mobileNumber(driver.getMobileNumber())
                .cabResponse(CabTransformer.cabToCabResponse(driver.getCab()))

                    .build();
    }
}
