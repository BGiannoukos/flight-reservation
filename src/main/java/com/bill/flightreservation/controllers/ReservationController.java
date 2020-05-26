package com.bill.flightreservation.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bill.flightreservation.dto.ReservationRequest;
import com.bill.flightreservation.entities.Flight;
import com.bill.flightreservation.entities.Reservation;
import com.bill.flightreservation.repos.FlightRepository;
import com.bill.flightreservation.services.ReservationService;

@Controller
public class ReservationController {
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	ReservationService reservationService;
	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId")Long flightId,ModelMap modelMap) {
		
	   Optional<Flight> flight = flightRepository.findById(flightId);
	   if (flight.isPresent()) {
		   modelMap.addAttribute("flight", flight.get());
	   }
		return "completeReservation";
	}
	
	@PostMapping("/completeReservation")
	public String completeReservation(ReservationRequest request, ModelMap modelMap) {
		Reservation reservation = reservationService.bookFlight(request);
		modelMap.addAttribute("msg","Reservation created succesfully and the id is: " + reservation.getId());
		
		return "reservationConfirmation";
				
	}

}
