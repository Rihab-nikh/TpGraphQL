package org.example.videoservice.web;

import org.example.videoservice.dao.Repositories.CreatorRepository;
import org.example.videoservice.dao.Repositories.VideoRepository;
import org.example.videoservice.dao.entities.Creator;
import org.example.videoservice.dao.entities.Video;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class VideoGraphQIController {
    private final CreatorRepository creatorRepository;
    private final VideoRepository videoRepository;
    VideoGraphQIController(CreatorRepository creatorRepository, VideoRepository videoRepository){
        this.creatorRepository = creatorRepository;
        this.videoRepository = videoRepository;
    }
    @QueryMapping
    public List<Video> videoList(){
        return videoRepository.findAll().stream().toList();
    }
    @QueryMapping
    public Creator creatorById(@Argument Long id) {
        return creatorRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Creator %s not found",id)));
    }
}
