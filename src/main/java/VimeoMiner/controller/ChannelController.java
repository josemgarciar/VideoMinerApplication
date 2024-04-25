package VimeoMiner.controller;

import VimeoMiner.exception.ChannelNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import VimeoMiner.repository.ChannelRepository;
import VimeoMiner.model.channel.Channel;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("https://api.vimeo.com/channels/")
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
    public void update(@PathVariable Long id, @Valid @RequestBody Channel updatedChannel) throws ChannelNotFoundException {
        Optional<Channel> oldChannel = repository.findById(id);

        if(oldChannel.isEmpty()){
            throw new ChannelNotFoundException();
        } else {
            Channel channel = oldChannel.get();
            channel.setName(updatedChannel.getName());
            channel.setDescription(updatedChannel.getDescription());
            channel.setCreatedTime(updatedChannel.getCreatedTime());
            channel.setUri(updatedChannel.getUri());
            repository.save(channel);
            /* JRP: We don't include the videos in the put request, just like in the lab 7.
             */
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws ChannelNotFoundException {
        Optional<Channel> channel = repository.findById(id);

        if(channel.isEmpty()){
            throw new ChannelNotFoundException();
        } else {
            repository.delete(channel.get());
        }
    }

}
