package VideoMiner.videoController;

import VideoMiner.model.*;
import VideoMiner.repository.ChannelRepository;
import VimeoMiner.model.comments.CommentsList;
import VimeoMiner.model.video.VideoList;
import YoutubeMiner.model.caption.CaptionSearch;
import YoutubeMiner.model.channel.ChannelSearch;
import YoutubeMiner.model.comment.CommentSearch;
import YoutubeMiner.model.video.VideoSnippet;
import YoutubeMiner.model.video.VideoSnippetSearch;
import exception.ChannelNotFoundException;
import exception.VideoWithoutCommentsException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "Youtube", description ="Youtube API")
@RestController
@RequestMapping("/youtube")
public class YoutubeController {
    @Autowired
    ChannelRepository channelRepository;

    String tokenYT = "AIzaSyBSCMH5ASLuIxXKRN-_AV0ExAY_pr7GDiQ";
    String baseUriYT ="https://www.googleapis.com/youtube/v3";
    RestTemplate restTemplate = new RestTemplate();

    VideoMiner.transforms.youtube YoutubeTransform;

    @Operation(summary = "Find a channel by id", description = "Find a channel by id in Youtube API", tags = { "Youtube", "Get operations"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Channel from Youtube",
                    content = {@Content(schema = @Schema(implementation = Channel.class),
                            mediaType = "application/json")
                    }),

            @ApiResponse(responseCode = "404", description = "Channel not found",
                    content = {@Content(schema = @Schema())
                    })
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Channel findOneYoutube(@Parameter(description ="ID of the channel to be searched") @PathVariable String id,
                                  @Parameter(description = "Maximum number of videos to be posted. Only used when called from the POST operation")@RequestParam(required = false, defaultValue = "10") Integer maxVideos,
                                  @Parameter(description = "Maximum number of comments to be posted. Only used when called from the POST operation")@RequestParam(required = false, defaultValue = "10")Integer maxComments) throws ChannelNotFoundException, VideoWithoutCommentsException {

        HttpHeaders header = new HttpHeaders();
        HttpEntity<ChannelSearch> request = new HttpEntity<>(null, header);

        String uri = baseUriYT + "/channels" + "?key=" + tokenYT + "&id=" + id + "&part=snippet";

        ResponseEntity<ChannelSearch> response =
                restTemplate.exchange(uri, HttpMethod.GET, request, ChannelSearch.class);

        if(response.getBody() == null){
            throw new ChannelNotFoundException();
        } else {
            Channel videoChannel =  VideoMiner.transforms.youtube.convertToChannel(response.getBody(), id);
            if(videoChannel.getVideos().size() > maxVideos){
                videoChannel.setVideos(videoChannel.getVideos().subList(0, maxVideos));
            }
            for (Video v : videoChannel.getVideos()){
                if(v.getComments().size() > maxComments) {
                    v.setComments(v.getComments().subList(0,maxComments));
                }
            }
            return videoChannel;
        }
    }

    @Operation(summary = "Post a Youtube Channel to the DataBase", description = "Post a Youtube Channel in DataBase giving the id of the Youtube channel", tags = { "Youtube", "Post operations"})
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Post a channel from Youtube to the database",
                    content = {@Content(schema = @Schema(implementation = Channel.class),
                            mediaType = "application/json")
                    }),

            @ApiResponse(responseCode = "404", description = "Channel not found",
                    content = {@Content(schema = @Schema())
                    })
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{id}")
    public Channel saveYouTube(@Parameter(description = "ID of the channel to be searched in Youtube and saved in the DataBase")@PathVariable String id,
            @Parameter(description= "Maximum number of videos to post")@RequestParam(required = false, defaultValue = "10") Integer maxVideos,
            @Parameter(description= "Maximum number of comments to post")@RequestParam(required = false, defaultValue = "10") Integer maxComments) throws ChannelNotFoundException, VideoWithoutCommentsException {
        Channel channel = findOneYoutube(id, maxVideos, maxComments);
        channelRepository.save(channel);
        return channel;
    }
}
