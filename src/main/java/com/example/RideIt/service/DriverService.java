package com.example.RideIt.service;

import com.example.RideIt.dto.request.CabRequest;
import com.example.RideIt.dto.request.DriverRequest;
import com.example.RideIt.dto.response.DriverResponse;
import com.example.RideIt.model.Cab;
import com.example.RideIt.model.Driver;
import com.example.RideIt.repository.CabRepository;
import com.example.RideIt.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.RideIt.transformer.CabTransformer.cabRequestToCab;
import static com.example.RideIt.transformer.DriverTransformer.driverRequestToDriver;
import static com.example.RideIt.transformer.DriverTransformer.driverToDriverResponse;

@Service
public class DriverService {
//    @Autowired
//    DriverRepository driverRepository;

    private final DriverRepository driverRepository;

    public DriverService( DriverRepository driverRepository){
        this.driverRepository = driverRepository;
    }

    // We using cascading so we dont need to autowire the cabRepository  , it will automatically saved im cabRepository
//    @Autowired
//    CabRepository cabRepository;

    public String addDriver(DriverRequest driverRequest){

        CabRequest cabRequest = driverRequest.getCab();
        //convert  driver request to driver object
        // convert cabRequest to cab object

        Driver driver = driverRequestToDriver(driverRequest);
        Cab cab = cabRequestToCab(cabRequest);

        driver.setCab(cab);
        cab.setDriver(driver);

        Driver savedDriver = driverRepository.save(driver);
        // we used cascading so if we perform any operation  same operation will be performed in Cab
        // we don't need to save cab , it will be automatically saved

        //Cab savedCab = cabRepository.save(cab);

        return "driver and cabs are saved";
    }
}
