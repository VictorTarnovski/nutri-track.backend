package com.nutri_track.domain.repositories;

import com.nutri_track.domain.entities.Professional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalRepository extends JpaRepository<Professional, Long>, JpaSpecificationExecutor<Professional> { }
