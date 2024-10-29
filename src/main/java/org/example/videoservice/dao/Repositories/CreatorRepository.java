package org.example.videoservice.dao.Repositories;

import org.example.videoservice.dao.entities.Creator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreatorRepository extends JpaRepository<Creator, Long> {
}
