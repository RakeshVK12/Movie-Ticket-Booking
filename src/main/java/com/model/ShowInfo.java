package com.model;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;

@Entity
@Valid
@AllArgsConstructor
public class ShowInfo {
	
	@Id
	@NotBlank(message="Provide Valid Id")
	@Column(length=10)
	private String showId;
	
	@NotBlank(message="Provide Valid Title")
	private String title;
	
	@NotBlank(message="Provide Valid Language")
	private String language;
	
	@NotBlank(message="Provide Valid Genre")
	private String genre;
	
	@NotBlank(message="Provide Valid Venue")
	private String venue;
	
	@FutureOrPresent(message="Provide Valid Start Date")
	private LocalDate startDate;
	
	@Min(value=30, message="Duration is betwwen 30 and 120")
	@Max(value=30, message="Duration is between 30 and 120")
	private int duration;
	
	@Positive(message="Provide valid Ticket Price")
	private double ticketPrice;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="showObj")
	@JsonIgnoreProperties("showObj")
	private List<Booking> bookings;
}
