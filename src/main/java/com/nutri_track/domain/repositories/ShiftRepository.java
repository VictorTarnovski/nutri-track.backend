package com.nutri_track.domain.repositories;

import com.nutri_track.domain.entities.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftRepository extends JpaRepository<Shift, Long>, JpaSpecificationExecutor<Shift> { }
