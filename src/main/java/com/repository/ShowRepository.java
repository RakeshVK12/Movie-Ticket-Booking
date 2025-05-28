package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.model.ShowInfo;

@Repository
public interface ShowRepository extends JpaRepository<ShowInfo,String> {
	
	List<ShowInfo> findByGenreAndLanguage(String genre, String language);
	
	@Query(value = "SELECT s.show_id AS showId, COUNT(b.booking_id) AS ticketCount FROM booking b JOIN show_info s ON b.show_id = s.show_id GROUP BY s.show_id", nativeQuery = true)
	List<Object[]> getShowWiseTicketCount();
//	List<Object[]> getShowWiseTicketCount();


}
