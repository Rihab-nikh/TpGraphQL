package org.example.videoservice;

import org.example.videoservice.dao.Repositories.CreatorRepository;
import org.example.videoservice.dao.Repositories.VideoRepository;
import org.example.videoservice.dao.entities.Creator;
import org.example.videoservice.dao.entities.Video;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class VideoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideoServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CreatorRepository creatorRepository, VideoRepository videoRepository) {
        return args -> {
            List<Creator> creators = List.of(
                    Creator.builder()
                            .name("Creator1")
                            .email("creator1@gmail.com")
                            .build(),
                    Creator.builder()
                            .name("Creator2")
                            .email("creator2@gmail.com")
                            .build()
            );

            creatorRepository.saveAll(creators);


            List<Video> videos = List.of(
                    Video.builder()
                            .name("Video1")
                            .url("http://example.com/video1")
                            .description("First video")
                            .datePublication(new Date())
                            .creator(creators.get(0))
                            .build(),
                    Video.builder()
                            .name("Video2")
                            .url("http://example.com/video2")
                            .description("Second video")
                            .datePublication(new Date())
                            .creator(creators.get(1))
                            .build()
            );


            videoRepository.saveAll(videos);
        };
    }
}