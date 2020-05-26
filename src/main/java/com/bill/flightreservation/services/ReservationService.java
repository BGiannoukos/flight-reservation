package com.bill.flightreservation.services;


import com.bill.flightreservation.dto.ReservationRequest;
import com.bill.flightreservation.entities.Reservation;



public interface ReservationService {

	public Reservation bookFlight(ReservationRequest request);
}
