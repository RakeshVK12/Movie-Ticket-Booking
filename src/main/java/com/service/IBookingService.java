package com.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.exception.InvalidEntityException;
import com.model.Booking;
import com.model.ShowInfo;
import com.repository.BookingRepository;
import com.repository.ShowRepository;

public class IBookingService implements BookingService{
	
	@Autowired
	private BookingRepository repo;
	
	@Autowired
	private ShowRepository showrepo;
	
	
	
	public Booking bookAShow(Booking booking, String showId) throws InvalidEntityException{
		
		ShowInfo show = showrepo.findById(showId)
				.orElseThrow(()-> new InvalidEntityException("Show Id is not found"));
		
		booking.setShowInfo(show);
		repo.save(booking);
		return booking;
	}



	
	public Booking updateTicketCount(String bookingId, int ticketCount) throws InvalidEntityException {
		
		Booking book = repo.findById(bookingId)
				.orElseThrow(() -> new InvalidEntityException("Booking with ID " + bookingId + " not found."));
 
		book.setTicketCount(ticketCount);
		
		
		return repo.save(book);
	}



	@Override
	public List<Booking> viewBookingByDate(LocalDate bookingDate) throws InvalidEntityException {
		List<Booking> bookings = repo.findBookingByBookingDate(bookingDate);
				                     
		return bookings;
	}



	@Override
	public List<Booking> viewBookingByShowId(String showId) throws InvalidEntityException {
		ShowInfo show = showrepo.findById(showId)
				.orElseThrow(() -> new InvalidEntityException("Show Id "+ showId+" is not found"));
		return repo.showBookingByShowId(showId);
	}



	@Override
	public Booking cancelBooking(String bookingId) throws InvalidEntityException {
		Booking book = repo.findById(bookingId)
				.orElseThrow(()-> new InvalidEntityException("Booking Id "+ bookingId +" not found"));
		
		 repo.delete(book);
		return book;
	}
	
	
}
