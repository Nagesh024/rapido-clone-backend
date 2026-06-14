package com.rapido.search.repository;

import com.rapido.search.model.SearchEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;
public interface SearchEventRepository
        extends JpaRepository<SearchEvent, Long> {
	List<SearchEvent> findByCreatedAtAfter(
	        LocalDateTime dateTime);
}