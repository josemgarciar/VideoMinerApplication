package VideoMiner.videoController;

import VideoMiner.model.Channel;
import VideoMiner.model.Video;
import VideoMiner.repository.ChannelRepository;
import VideoMiner.repository.VideoRepository;
import VimeoMiner.model.video.VideoList;
import YoutubeMiner.service.YoutubeChannelService;
import YoutubeMiner.service.YoutubeVideoService;
import exception.ChannelNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/videominer/channels")
public class ChannelController {


    @Autowired
    ChannelRepository repository;


    @GetMapping()
    public List<Channel> getChannels() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Channel findOne(@PathVariable String id) throws ChannelNotFoundException {

        Optional<Channel> channel = repository.findAll().stream().filter(x -> x.getId().equals(id)).findFirst();

        if(channel.isEmpty()){
            throw new ChannelNotFoundException();
        }

        return channel.get();
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public Channel create(@Valid @RequestBody Channel channel) {
        repository.save(channel);
        return channel;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @Valid @RequestBody Channel channel) throws ChannelNotFoundException {
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

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws ChannelNotFoundException {
        Optional<Channel> foundChannel = repository.findById(id);

        if(foundChannel.isEmpty()){
            throw new ChannelNotFoundException();
        }

        repository.deleteById(id);
    }
}
