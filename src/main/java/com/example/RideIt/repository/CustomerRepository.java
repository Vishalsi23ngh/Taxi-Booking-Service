package com.example.RideIt.repository;

import com.example.RideIt.ENUM.Gender;
import com.example.RideIt.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer,Integer> {

//    @Query(value = "select * from customer where gender= :gender and age >= :age",nativeQuery = true )
//    public List<Customer> getByGenderAndGreaterThan(String gender,int age );

    @Query(value = "select c from Customer c where c.gender= :gender and age >= :age")
    public List<Customer> getByGenderAndGreaterThan(Gender gender, int age );




    Customer findByEmailId(String emailId);
}
