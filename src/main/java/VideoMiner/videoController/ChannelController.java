package VideoMiner.videoController;

import VideoMiner.model.Channel;
import VideoMiner.model.Video;
import VideoMiner.repository.ChannelRepository;
import VideoMiner.repository.VideoRepository;
import exception.ChannelNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Tag(name = "Channels", description ="Channels operations")
@RestController
@RequestMapping("/videominer/channels")
public class ChannelController {


    @Autowired
    ChannelRepository repository;

    @Operation(summary = "Get all channels", description = "Retrieve all channels from VideoMiner", tags = { "Channels", "Get operations"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Channel from Vimeo",
                    content = {@Content(schema = @Schema(implementation = Channel.class),
                            mediaType = "application/json")
                    })
    })
    @GetMapping()
    public List<Channel> getChannels(@Parameter(description = "Name of the channel. Used to search channels by its name.") @RequestParam(required = false) String name,
                                     @Parameter(description = "If present, determines the order of the response according to the parameter received.")@RequestParam(required = false) String order, // + o -
                                     @Parameter(description = "Number of the response page. By default, VideoMiner will show the first page.")@RequestParam(defaultValue = "0") int page,
                                     @Parameter(description = "Size of the response page. By default, VideoMiner will show one channel per page.")@RequestParam(defaultValue = "1") int size) {

        Pageable paging;

        if (order != null) {
            if (order.startsWith("-"))
                paging = PageRequest.of(page, size, Sort.by(order.substring(1)).descending());
            else
                paging = PageRequest.of(page, size, Sort.by(order).ascending());
        } else {
            paging = PageRequest.of(page, size);
        }


        Page<Channel> pageChannels;

        if(name == null) {
            pageChannels = repository.findAll(paging);
        } else {
            pageChannels = repository.findByName(name, paging);
        }

        return pageChannels.getContent();
    }

    @Operation(summary = "Find a channel by id", description = "Find a channel by id in VimeoMiner", tags = { "Channels", "Get operations"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Channel from VideoMiner",
                    content = {@Content(schema = @Schema(implementation = Channel.class),
                            mediaType = "application/json")
                    }),

            @ApiResponse(responseCode = "404", description = "Channel not found",
                    content = {@Content(schema = @Schema())
                    })
    })
    @GetMapping("/{id}")
    public Channel findOne(@Parameter(description = "ID of the channel to be searched")@PathVariable String id) throws ChannelNotFoundException {

        Optional<Channel> channel = repository.findAll().stream().filter(x -> x.getId().equals(id)).findFirst();

        if(channel.isEmpty()){
            throw new ChannelNotFoundException();
        }

        return channel.get();
    }

    @Operation(summary = "Create a channel", description = "Post a channel to the database", tags = { "Channels", "Post operations"})
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Channel posted in the database",
                    content = {@Content(schema = @Schema(implementation = Channel.class),
                            mediaType = "application/json")
                    })
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public Channel create(@Parameter(description = "Channel to be posted in the database")@Valid @RequestBody Channel channel) {
        repository.save(channel);
        return channel;
    }

    @Operation(summary = "Update a channel", description = "Update channel information given the channel ID.", tags = { "Channels", "Put operations"})
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Channel updated",
                    content = {@Content(schema = @Schema())
                    }),

            @ApiResponse(responseCode = "404", description = "Channel not found",
                    content = {@Content(schema = @Schema())
                    })
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@Parameter(description = "ID of the channel to be updated")@PathVariable Long id,
                       @Parameter(description = "Channel object with the updated information.")@Valid @RequestBody Channel channel) throws ChannelNotFoundException {
        Optional<Channel> foundChannel = repository.findById(id);

        if(foundChannel.isEmpty()){
            throw new ChannelNotFoundException();
        }

        foundChannel.get().setDescription(channel.getDescription());
        foundChannel.get().setName(channel.getName());
        foundChannel.get().setVideos(channel.getVideos());

        // No se cambia la fecha de creacion

        repository.save(channel);
    }

    @Operation(summary = "Delete a channel", description = "Delete a channel from the database given the channel ID", tags = { "Channels", "Delete operations"})
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Channel deleted",
                    content = {@Content(schema = @Schema())
                    }),

            @ApiResponse(responseCode = "404", description = "Channel not found",
                    content = {@Content(schema = @Schema())
                    })
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@Parameter(description = "ID of the channel to be deleted")@PathVariable Long id) throws ChannelNotFoundException {
        Optional<Channel> foundChannel = repository.findById(id);

        if(foundChannel.isEmpty()){
            throw new ChannelNotFoundException();
        }

        repository.deleteById(id);
    }
}
