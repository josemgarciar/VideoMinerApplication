package VideoMiner.videoController;

import VideoMiner.model.*;
import VimeoMiner.model.comments.CommentsList;
import VimeoMiner.model.video.VideoList;
import exception.ChannelNotFoundException;
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
import VideoMiner.repository.ChannelRepository;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "Vimeo", description ="Vimeo API")
@RestController
@RequestMapping("/vimeo")
public class VimeoController {

    @Autowired
    ChannelRepository channelRepository;

    String baseUriVimeo = "https://api.vimeo.com/channels/";
    String tokenVimeo = "152307b18fa3949c3591a895137abe8e";

    VideoMiner.transforms.vimeo VimeoTransform;

    RestTemplate restTemplate = new RestTemplate();

    @Operation(summary = "Find a channel by id", description = "Find a channel by id in Vimeo API", tags = { "Vimeo", "get"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Channel from Vimeo",
                    content = {@Content(schema = @Schema(implementation = Channel.class),
                            mediaType = "application/json")
            }),

            @ApiResponse(responseCode = "404", description = "Channel not found",
                    content = {@Content(schema = @Schema())
            })
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Channel findOneVimeo(@Parameter(description ="ID of the channel to be searched") @PathVariable String id) throws ChannelNotFoundException {

        HttpHeaders header = new HttpHeaders();
        header.set("Authorization", "bearer " + tokenVimeo);
        HttpEntity<VimeoMiner.model.channel.Channel> request = new HttpEntity<>(null, header);

        ResponseEntity<VimeoMiner.model.channel.Channel> response = restTemplate.exchange(baseUriVimeo + id , HttpMethod.GET, request, VimeoMiner.model.channel.Channel.class);

        if(response.getBody() == null){
            throw new ChannelNotFoundException();
        } else {
            return VimeoTransform.convertToChannel(response, id);
        }


    }

    @Operation(summary = "Post a Vimeo Channel", description = "Post a Vimeo Channel in DataBase giving the id of the Vimeo channel", tags = { "Vimeo", "post"})
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Post a channel from Vimeo to the database",
                    content = {@Content(schema = @Schema(implementation = Channel.class),
                            mediaType = "application/json")
                    }),

            @ApiResponse(responseCode = "404", description = "Channel not found",
                    content = {@Content(schema = @Schema())
                    })
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{id}")
    public Channel saveVimeo(@Parameter (description = "ID of the channel to be searched in Vimeo and saved in the DataBase") @PathVariable String id) throws ChannelNotFoundException {
        Channel channel = findOneVimeo(id);
        channelRepository.save(channel);
        return channel;
    }


}