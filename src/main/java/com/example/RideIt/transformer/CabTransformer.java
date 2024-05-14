package com.example.RideIt.transformer;

import com.example.RideIt.dto.request.CabRequest;
import com.example.RideIt.dto.response.CabResponse;
import com.example.RideIt.model.Cab;

public class CabTransformer {

    public static Cab cabRequestToCab(CabRequest cabRequest){
        return Cab.builder()
                .company(cabRequest.getCompany())
                .carModel(cabRequest.getCarModel())
                .carType(cabRequest.getCarType())
                .noOfSeats(cabRequest.getNoOfSeats())
                .farePerKm(cabRequest.getFarePerKm())
                .cabNo(cabRequest.getCabNo())
                .available(true)
                .build();
    }

    public static CabResponse cabToCabResponse(Cab cab){
        return  CabResponse.builder()
                .cabNo(cab.getCabNo())
                .farePerKm(cab.getFarePerKm())
                .noOfSeats(cab.getNoOfSeats())
                .company(cab.getCompany())
                .carModel(cab.getCarModel())
                .build();
    }
}
