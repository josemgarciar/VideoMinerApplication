package VideoMiner.videoController;

import VimeoMiner.exception.ChannelNotFoundException;
import VimeoMiner.model.channel.Channel;
import VimeoMiner.repository.ChannelRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

}
