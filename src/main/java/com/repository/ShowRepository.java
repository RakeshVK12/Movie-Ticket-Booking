package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.ShowInfo;

@Repository
public interface ShowRepository extends JpaRepository<ShowInfo,String> {

}
