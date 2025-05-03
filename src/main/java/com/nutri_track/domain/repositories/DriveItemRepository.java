package com.nutri_track.domain.repositories;

import com.nutri_track.domain.entities.DriveItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DriveItemRepository extends JpaRepository<DriveItem, UUID>, JpaSpecificationExecutor<DriveItem> { }
