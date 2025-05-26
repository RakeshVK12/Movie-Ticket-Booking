package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repository.BookingRepository;
import com.repository.ShowRepository;

@Service
public class ShowService {
	
	@Autowired
	BookingRepository repo;
	
	@Autowired
	ShowRepository showRepo;
}
