package com.model;

import java.time.LocalDate;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Data
@AllArgsConstructor
@Getter
@Setter
public class Booking {
	
	@Id
	@NotBlank(message="Booking Id must be valid")
	private String bookingId;
	
	@FutureOrPresent(message="Bookinf date must be valid")
	private LocalDate bookingDate;
	
	@NotBlank(message="Provide value for Booked by")
	private String bookedBy;
	
	@NotBlank(message="Provide valid phone number")
	private String contactNumber;
	
	@Positive(message="Provide valid ticket count")
	private int ticketCount;
	
	@NotBlank(message="Provide valid Payment Status")
	private String paymentStatus;
	
	@ManyToOne
	@JoinColumn(name="showId")
	@JsonIgnoreProperties("bookingList")
	private ShowInfo showInfo;

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getBookedBy() {
		return bookedBy;
	}

	public void setBookedBy(String bookedBy) {
		this.bookedBy = bookedBy;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public int getTicketCount() {
		return ticketCount;
	}

	public void setTicketCount(int ticketCount) {
		this.ticketCount = ticketCount;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public ShowInfo getShowInfo() {
		return showInfo;
	}

	public void setShowInfo(ShowInfo showInfo) {
		this.showInfo = showInfo;
	}
	
	
	
}
