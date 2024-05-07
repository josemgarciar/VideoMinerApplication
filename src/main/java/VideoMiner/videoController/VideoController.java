package VideoMiner.videoController;


import VideoMiner.model.Caption;
import VideoMiner.model.User;
import VideoMiner.model.Video;
import VideoMiner.repository.VideoRepository;
import exception.VideoNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Tag(name="Videos", description = "Videos operations")
@RestController
@RequestMapping("/videominer/videos")
public class VideoController {

    @Autowired
    VideoRepository videoRepository;

    @Operation(summary = "Find all videos", description = "Retrieve all videos from VideoMiner", tags = { "Videos", "Get operations"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Videos from the database",
                    content = {@Content(schema = @Schema(implementation = Video.class),
                            mediaType = "application/json")
                    })
    })
    @GetMapping
    public List<Video> getVideos(@Parameter(description = "Name of the video. Used to search videos by its name.") @RequestParam(required = false) String name,
                                 @Parameter(description = "If present, determines the order of the response according to the parameter received.")@RequestParam(required = false) String order, // + o -
                                 @Parameter(description = "Number of the response page. By default, VideoMiner will show the first page.")@RequestParam(defaultValue = "0") int page,
                                 @Parameter(description = "Size of the response page. By default, VideoMiner will show one video per page.")@RequestParam(defaultValue = "5") int size) {
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

    @Operation(summary = "Find a video by id", description = "Find a video by id in VideoMiner", tags = { "Videos", "Get operations"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Video from VideoMiner by its ID",
                    content = {@Content(schema = @Schema(implementation = Video.class),
                            mediaType = "application/json")
                    }),

            @ApiResponse(responseCode = "404", description = "Video not found",
                    content = {@Content(schema = @Schema())
                    })
    })
    @GetMapping("/{id}")
    public Video findOne(@Parameter(description = "ID of the video to be searched")@PathVariable String id) throws VideoNotFoundException {

        Optional<Video> video = videoRepository.findAll().stream().filter(x -> x.getId().equals(id)).findFirst();

        if(video.isEmpty()){
            throw new VideoNotFoundException();
        }

        return video.get();
    }

    @Operation(summary = "Create a video", description = "Post a video to the database", tags = { "Videos", "Post operations"})
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Video posted in the database",
                    content = {@Content(schema = @Schema(implementation = Video.class),
                            mediaType = "application/json")
                    })
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Video create(@Parameter(description = "Video to be posted in the database")@RequestBody Video video) {
        videoRepository.save(video);
        return video;
    }

    @Operation(summary = "Update a video", description = "Update video information given the video ID.", tags = { "Videos", "Put operations"})
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Video updated",
                    content = {@Content(schema = @Schema())
                    }),

            @ApiResponse(responseCode = "404", description = "Video not found",
                    content = {@Content(schema = @Schema())
                    })
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@Parameter(description = "ID of the video to be updated")@PathVariable Long id,
                       @Parameter(description = "Video object with the updated information")@RequestBody Video video) throws VideoNotFoundException {
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

    @Operation(summary = "Delete a video", description = "Delete a video from the database given the video ID", tags = { "Videos", "Delete operations"})
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Video deleted",
                    content = {@Content(schema = @Schema())
                    }),
            @ApiResponse(responseCode = "404", description = "Video not found",
                    content = {@Content(schema = @Schema())
                    })
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@Parameter(description = "ID of the video to be deleted")@PathVariable Long id) throws VideoNotFoundException {
        Optional<Video> video = videoRepository.findById(id);

        if(video.isEmpty()){
            throw new VideoNotFoundException();
        }

        videoRepository.delete(video.get());
    }



}
