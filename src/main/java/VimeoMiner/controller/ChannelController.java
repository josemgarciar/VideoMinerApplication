package VimeoMiner.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import VimeoMiner.repository.ChannelRepository;
import VimeoMiner.model.channel.Channel;
import java.util.List;

@RestController
@RequestMapping("https://api.vimeo.com/channels/")
public class ChannelController {
    private final ChannelRepository repository;

    public ChannelController(ChannelRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Channel> getChannels() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Channel findOne(@PathVariable String id) {
        return repository.findOne(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Channel create(@Valid @RequestBody Channel channel) {
        return repository.create(channel);
    }
}
