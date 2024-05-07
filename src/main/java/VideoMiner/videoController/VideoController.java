package VideoMiner.videoController;


import VideoMiner.model.User;
import VideoMiner.model.Video;
import VideoMiner.repository.VideoRepository;
import exception.VideoNotFoundException;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public List<Video> getVideos(@Parameter(description = "Name of the comment. Used to search videos by its name.") @RequestParam(required = false) String name,
                                 @Parameter(description = "If present, determines the order of the response according to the parameter received.")@RequestParam(required = false) String order, // + o -
                                 @Parameter(description = "Number of the response page. By default, VideoMiner will show the first page.")@RequestParam(defaultValue = "0") int page,
                                 @Parameter(description = "Size of the response page. By default, VideoMiner will show one video per page.")@RequestParam(defaultValue = "1") int size) {
        Pageable paging;

        if (order != null) {
            if (order.startsWith("-"))
                paging = PageRequest.of(page, size, Sort.by(order.substring(1)).descending());
            else
                paging = PageRequest.of(page, size, Sort.by(order).ascending());
        } else {
            paging = PageRequest.of(page, size);
        }

        Page<Video> pageVideos;

        if(name == null) {
            pageVideos = videoRepository.findAll(paging);
        } else {
            pageVideos = videoRepository.findByName(name, paging);
        }
        return pageVideos.getContent();
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
