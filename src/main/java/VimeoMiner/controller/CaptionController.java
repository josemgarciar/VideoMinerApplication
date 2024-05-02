package VimeoMiner.controller;

import exception.CaptionNotFoundException;
import exception.VideoNotFoundException;
import VimeoMiner.model.caption.TextTrack;
import VimeoMiner.model.video.Video;
import VimeoMiner.repository.CaptionRepository;
import VimeoMiner.repository.VideoRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("https://api.vimeo.com/videos/{id}/texttracks")
public class CaptionController {

    @Autowired
    CaptionRepository captionRepository;
    VideoRepository videoRepository;


    @GetMapping("/videos/{id}/texttracks")
    public List<TextTrack> getAllCaptionsByVideoId(@PathVariable Long id) throws VideoNotFoundException {
        Optional<Video> video = videoRepository.findById(id);

        if(video.isEmpty()){
            throw new VideoNotFoundException();
        }

        return video.get().getCaptions();
    }

    @GetMapping("texttracks/{id}")
    public TextTrack findOne(@PathVariable Long id) throws CaptionNotFoundException {
        Optional<TextTrack> caption = captionRepository.findById(id);

        if(caption.isEmpty()){
            throw new CaptionNotFoundException();
        }

        return caption.get();
    }

    @PostMapping("/videos/{id}/texttracks")
    @ResponseStatus(HttpStatus.CREATED)
    public TextTrack createCaption(@RequestBody TextTrack caption, @PathVariable Long id) throws VideoNotFoundException {
        Optional<Video> video = videoRepository.findById(id);

        if (video.isEmpty()) {
            throw new VideoNotFoundException();
        } else {
            video.get().getCaptions().add(caption);
            captionRepository.save(caption);
        }
        return caption;
    }
}
