package org.example.videoservice.dao.Repositories;

import org.example.videoservice.dao.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
