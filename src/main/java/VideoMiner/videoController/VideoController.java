package VideoMiner.videoController;


import VideoMiner.model.Video;
import VideoMiner.repository.VideoRepository;
import exception.VideoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/videominer/videos")
public class VideoController {

    @Autowired
    VideoRepository videoRepository;

    @GetMapping
    public List<Video> getVideos() {
        return videoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Video findOne(@PathVariable String id) throws VideoNotFoundException {

        Optional<Video> video = videoRepository.findAll().stream().filter(x -> x.getId().equals(id)).findFirst();

        if(video.isEmpty()){
            throw new VideoNotFoundException();
        }

        return video.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Video create(@RequestBody Video video) {
        videoRepository.save(video);
        return video;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Video video) throws VideoNotFoundException {
        Optional<Video> foundVideo = videoRepository.findById(id);

        if(foundVideo.isEmpty()){
            throw new VideoNotFoundException();
        }

        foundVideo.get().setName(video.getName());
        foundVideo.get().setDescription(video.getDescription());
        foundVideo.get().setCaptions(video.getCaptions());
        foundVideo.get().setComments(video.getComments());
        videoRepository.save(video);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws VideoNotFoundException {
        Optional<Video> video = videoRepository.findById(id);

        if(video.isEmpty()){
            throw new VideoNotFoundException();
        }

        videoRepository.delete(video.get());
    }


}
