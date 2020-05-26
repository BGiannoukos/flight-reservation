package com.bill.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bill.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
