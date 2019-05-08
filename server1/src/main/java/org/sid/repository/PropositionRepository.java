package org.sid.repository;

import org.sid.Entities.Proposition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropositionRepository extends JpaRepository<Proposition, Long> {
	 
}