package com.example.RideIt.service;

import com.example.RideIt.dto.request.TripBookingRequest;
import com.example.RideIt.dto.response.TripBookingResponse;
import com.example.RideIt.exception.CabNotAvailableException;
import com.example.RideIt.exception.CustomerNotFoundException;
import com.example.RideIt.model.Cab;
import com.example.RideIt.model.Customer;
import com.example.RideIt.model.TripBooking;
import com.example.RideIt.repository.CabRepository;
import com.example.RideIt.repository.CustomerRepository;
import com.example.RideIt.repository.DriverRepository;
import com.example.RideIt.repository.TripBookingRepository;
import com.example.RideIt.transformer.BookingTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TripBookingService {

   private  final TripBookingRepository tripBookingRepository;
   private final CustomerRepository  customerRepository;
    private  final DriverRepository driverRepository;
    private final CabRepository cabRepository;


    public TripBookingResponse bookCab(boolean applyCoupon, TripBookingRequest tripBookingRequest)  {

        Customer customer = customerRepository.findByEmailId(tripBookingRequest.getCustomerEmailId());
        if (customer == null) {
            throw new CustomerNotFoundException("Invalid email Id");
        }

        // check cab is available or not
        //get random cab
        Cab cab = cabRepository.getRandomAvailableCab();
        if(cab == null){
            throw  new CabNotAvailableException("Sorry no driver around!");
        }

        //prepare booking entity
        TripBooking tripBooking = BookingTransformer.bookingRequestToBooking(tripBookingRequest);
        tripBooking.setTotalFare(cab.getFarePerKm()*tripBooking.getTripDistanceInKm());
        tripBooking.setCustomer(customer);
        tripBooking.setDriver(cab.getDriver());

        TripBooking savedTripBooking = tripBookingRepository.save(tripBooking);

        customer.getBooking().add(savedTripBooking);
        cab.setAvailable(false);
        cab.getDriver().getBookings().add(savedTripBooking);

        customerRepository.save(customer);//sve customer and booking using cascading
        driverRepository.save(cab.getDriver());//save driver + cab + booking

        // prepare booking response
        return  BookingTransformer.tripBookingToTripBookingResponse(savedTripBooking);
    }
}
