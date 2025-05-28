package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.ShowInfo;
import com.service.IShowService;

@RestController
public class ShowController {
	
	@Autowired
	IShowService service;
	
	@PostMapping("/addShow")
	public ResponseEntity<ShowInfo> addShow(@RequestBody ShowInfo show){
		ShowInfo show1 = service.addShow(show);
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(show1);
		
	}
	
	@PutMapping("/updateShowDuration/{showId}/{duration}")
	public ResponseEntity<ShowInfo> updateShowDuration(@PathVariable String showId,@PathVariable int duration) {
		
		ShowInfo show = service.updateShowDuration(showId, duration);
		
		return ResponseEntity.ok(show);
	}
	
	@GetMapping("/test")
	public String test() {
	    return "Controller is working!";
	}
	
	@GetMapping("/getByShowId/{showId}")
	public ResponseEntity<ShowInfo> getByShowId(@PathVariable String showId) {
		ShowInfo show = service.getByShowId(showId);
		return ResponseEntity.ok(show);
	}
	
	@GetMapping("/viewByGenreAndLanguage/{genre}/{language}")
	public ResponseEntity<List<ShowInfo>> viewByGenreAndLanguage(@PathVariable String genre, @PathVariable String language) {
		List<ShowInfo> list = service.viewByGenreAndLanguage(genre, language);
		
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(list);
	}
	
	@GetMapping("/getShowWiseTicketCount")
	public ResponseEntity<Map<String, Integer>> getShowWiseTicketCount() {

		Map<String, Integer> map = service.getShowWiseTicketCount();
		
		return ResponseEntity.ok(map);
	}

}
