package com.service;

import java.time.LocalDate;
import java.util.List;

import com.exception.InvalidEntityException;
import com.model.Booking;

public interface BookingService {
	
	public Booking bookAShow(Booking booking, String showId) throws InvalidEntityException;
	
	public Booking updateTicketCount(String booking, int ticketCount) throws InvalidEntityException;
	
	public List<Booking> viewBookingByDate(LocalDate bookingDate) throws InvalidEntityException;
	
	public List<Booking> viewBookingByShowId(String showId) throws InvalidEntityException;

	public Booking cancelBooking(String bookingId) throws InvalidEntityException;
	

}
