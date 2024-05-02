package VimeoMiner.controller;

import exception.VideoNotFoundException;
import VimeoMiner.model.video.Video;
import VimeoMiner.repository.VideoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("https://api.vimeo.com/channels/{id}/videos")
public class VideoController {

    @Autowired
    VideoRepository repository;


    @GetMapping
    public List<Video> getVideos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Video findOne(@PathVariable Long id) throws VideoNotFoundException {

        Optional<Video> video = repository.findById(id);

        if(video.isEmpty()){
            throw new VideoNotFoundException();
        }

        return video.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Video create(@Valid @RequestBody Video video) {
        Video newVideo = repository.save(new Video(video));

        return newVideo;
    }

}
