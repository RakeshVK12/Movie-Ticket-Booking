package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exception.InvalidEntityException;
import com.model.Booking;
import com.service.IBookingService;

import jakarta.validation.Valid;

@RestController
public class BookingController {
	
	@Autowired
	private IBookingService service;
	
	@PostMapping("/bookAShow/{showId}")
	public ResponseEntity<Booking> bookAShow(@RequestBody @Valid Booking booking, @PathVariable String showId) throws InvalidEntityException{
//		ResponseEntity<Booking> book = service.bookAShow(booking, showId);
		
		
		return new ResponseEntity<>(service.bookAShow(booking, showId),HttpStatus.OK);			
		
	}
	
	
	public ResponseEntity<Booking> updateTicketCount(@PathVariable String bookingId, @PathVariable int ticketCount) throws InvalidEntityException {
		

		return new ResponseEntity<>(service.updateTicketCount(bookingId, ticketCount), HttpStatus.OK);
	}
	
}
