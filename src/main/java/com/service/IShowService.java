package com.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.ShowInfo;
import com.repository.ShowRepository;

@Service
public class IShowService implements ShowService {
	
//	@Autowired
//	BookingRepository repo;
	
	@Autowired
	ShowRepository showRepo;

	@Override
	public ShowInfo addShow(ShowInfo show) {
		ShowInfo info = showRepo.save(show);
		return info;
	}

	@Override
	public ShowInfo updateShowDuration(String showId, int duration) {
		ShowInfo info = showRepo.getById(showId);
		
		info.setDuration(duration);
		return showRepo.save(info);
	}

	@Override
	public ShowInfo viweByShowId(String showId) {
		ShowInfo info = showRepo.getById(showId);
		
		return info;
	}

	@Override
	public List<ShowInfo> viewByGenreAndLanguage(String genre, String language) {
		List<ShowInfo> show = showRepo.viewByGenreAndLanguage(genre, language);
		
		return show;
	}

	@Override
	public Map<String, Integer> getShowWiseTicketCount() {
		List<Object[]> results = showRepo.getShowWiseTicketCount();
		return results.stream().collect(Collectors.toMap(result -> (String) result[0], // Cast the first element to
																						// String (showId)
				result -> ((Number) result[1]).intValue() // Cast the second element to Number and then to Integer
		));
		 	}
}
