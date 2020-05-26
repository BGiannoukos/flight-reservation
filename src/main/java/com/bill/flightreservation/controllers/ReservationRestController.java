package com.bill.flightreservation.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bill.flightreservation.dto.ReservationUpdateRequest;
import com.bill.flightreservation.entities.Reservation;
import com.bill.flightreservation.repos.ReservationRepository;

@RestController
public class ReservationRestController {
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id")Long id) {
		Optional<Reservation> result = reservationRepository.findById(id);
		Reservation reservation =  new Reservation();
		if(result.isPresent()) {
			reservation = result.get();
		}
		return reservation;
	}
	
	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		
		Optional<Reservation> result = reservationRepository.findById(request.getId());
		Reservation reservation =  new Reservation();
		if(result.isPresent()) {
			reservation = result.get();
		}
		reservation.setCheckedIn(request.getCheckedIn());
		reservation.setNumberOfBags(request.getNumberOfBags());
		return reservationRepository.save(reservation);
	}

}
