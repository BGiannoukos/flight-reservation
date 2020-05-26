package com.bill.flightreservation.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill.flightreservation.dto.ReservationRequest;
import com.bill.flightreservation.entities.Flight;
import com.bill.flightreservation.entities.Passenger;
import com.bill.flightreservation.entities.Reservation;
import com.bill.flightreservation.repos.FlightRepository;
import com.bill.flightreservation.repos.PassengerRepository;
import com.bill.flightreservation.repos.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {
     
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {

		Long flightId = request.getFlightId();
		Optional<Flight>  result= flightRepository.findById(flightId);
		Flight flight = new Flight();
		if(result.isPresent()) {
			flight = result.get();
		}
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		Passenger savedPassenger = passengerRepository.save(passenger);
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		
		Reservation savedReservation = reservationRepository.save(reservation);
		
		return savedReservation;
	}

}
