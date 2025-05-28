package com.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		Booking book = service.bookAShow(booking, showId);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(book);
	}
	
	@PutMapping("/bookings/{bookingId}/ticketCount/{ticketCount}")
	public ResponseEntity<Booking> updateTicketCount(@PathVariable String bookingId, @PathVariable int ticketCount) throws InvalidEntityException {
		

		return new ResponseEntity<>(service.updateTicketCount(bookingId, ticketCount), HttpStatus.OK);
	}
	
	
	@GetMapping("/viewBookingByDate/{bookingDate}")
	public ResponseEntity<List<Booking>> viewBookingByDate(@PathVariable LocalDate bookingDate) throws InvalidEntityException {
		
		List<Booking> book = service.viewBookingByDate(bookingDate);
		return ResponseEntity.ok(book);
				
	}

	@GetMapping("/viewBookingByShowId/{showId}")
	public ResponseEntity<List<Booking>> viewBookingByShowId(@PathVariable String showId) throws InvalidEntityException{
		List<Booking> bookings = service.findByShowId(showId);
		
		return ResponseEntity.ok(bookings);
		
	}
	
	@DeleteMapping("/cancelBooking/{bookingId}")
	public ResponseEntity<Booking> cancelBooking(@PathVariable String bookingId) throws InvalidEntityException {
		Booking booking = service.cancelBooking(bookingId);
		
		return ResponseEntity.ok(booking);
		
	}
	
}
