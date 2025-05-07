package com.nutri_track.domain.repositories;

import com.nutri_track.domain.entities.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FileRepository extends JpaRepository<File, UUID>, JpaSpecificationExecutor<File> { }
