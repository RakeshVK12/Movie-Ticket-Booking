package com.service;

import java.util.List;
import java.util.Map;

import com.model.ShowInfo;

public interface ShowService {
	
	public ShowInfo addShow(ShowInfo show);
	
	public ShowInfo updateShowDuration(String showId, int duration);
	
	public ShowInfo getByShowId(String showId);
	
	public List<ShowInfo> viewByGenreAndLanguage(String genre, String language);
	
	public Map<String, Integer> getShowWiseTicketCount();
	
	
	
}
