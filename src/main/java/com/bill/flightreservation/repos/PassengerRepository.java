package com.bill.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bill.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
