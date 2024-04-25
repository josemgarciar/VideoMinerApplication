package VimeoMiner.controller;

import VimeoMiner.exception.CaptionNotFoundException;
import VimeoMiner.exception.VideoNotFoundException;
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

        if(video.isEmpty()){
            throw new VideoNotFoundException();
        } else {
            video.get().getCaptions().add(caption);
            captionRepository.save(caption);
        }
        return caption;
    }

    @PutMapping("/texttracks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody TextTrack updatedCaption) throws CaptionNotFoundException {
        Optional<TextTrack> oldCaption = captionRepository.findById(id);

        if(oldCaption.isEmpty()){
            throw new CaptionNotFoundException();
        } else {
            TextTrack caption = oldCaption.get();
            caption.setLanguage(updatedCaption.getLanguage());
            caption.setUri(updatedCaption.getUri());
            caption.setName(updatedCaption.getName());
            captionRepository.save(caption);
        }
    }

    @DeleteMapping("/texttracks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws CaptionNotFoundException {
        Optional<TextTrack> caption = captionRepository.findById(id);

        if(caption.isEmpty()){
            throw new CaptionNotFoundException();
        } else {
            captionRepository.delete(caption.get());
        }
    }
}
