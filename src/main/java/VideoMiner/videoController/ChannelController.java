package VideoMiner.videoController;

import VideoMiner.model.Channel;
import VideoMiner.repository.ChannelRepository;
import exception.ChannelNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("https://localhost:8080/videominer/channels")
public class ChannelController {

    @Autowired
    ChannelRepository repository;


    @GetMapping
    public List<Channel> getChannels() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Channel findOne(@PathVariable Long id) throws ChannelNotFoundException {

        Optional<Channel> channel = repository.findById(id);

        if(channel.isEmpty()){
            throw new ChannelNotFoundException();
        }

        return channel.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Channel create(@Valid @RequestBody Channel channel) {
        Channel newChannel = repository.save(new Channel(channel));

        return newChannel;
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
