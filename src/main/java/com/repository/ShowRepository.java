package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.model.ShowInfo;

@Repository
public interface ShowRepository extends JpaRepository<ShowInfo,String> {
	
	List<ShowInfo> viewByGenreAndLanguage(String genre, String language);
	
	@Query(value = "SELECT s.name AS showName, COUNT(t.id) AS ticketCount FROM tickets t JOIN shows s ON t.show_id = s.id GROUP BY s.name", nativeQuery = true)
	List<Object[]> getShowWiseTicketCount();


}
