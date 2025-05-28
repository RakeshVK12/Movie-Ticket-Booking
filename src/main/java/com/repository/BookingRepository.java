package com.repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {
	
	public List<Booking> findBookingByBookingDate(LocalDate bookingDate);

	public List<Booking> findByShowInfoShowId(String showId);

}
