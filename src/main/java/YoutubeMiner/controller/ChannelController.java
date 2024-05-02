package YoutubeMiner.controller;

import exception.ChannelNotFoundException;
import YoutubeMiner.model.channel.Channel;
import YoutubeMiner.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("https://www.googleapis.com/youtube/v3/channels")
public class ChannelController {

    @Autowired
    ChannelRepository channelRepository;
    @GetMapping
    public List<Channel> getChannels(){
        return channelRepository.findAll();
    }
    @GetMapping("/{id}")
    public Channel findOne(@PathVariable Long id) throws ChannelNotFoundException {
        Optional<Channel> foundChannel = channelRepository.findById(id);

        if(foundChannel.isEmpty()){
            throw new ChannelNotFoundException();
        }

        return foundChannel.get();
    }

    @PostMapping //La URI del POST maping es la de nuestra API. Ídem para todos los POST de todos los controllers de Vimeo y Youtube
    public Channel create(@RequestBody Channel channel){
        Channel newChannel = channelRepository.save(new Channel(channel));
        /*Además, el canal que mandemos no nos llega como parámetro, sino que lo cogemos de la API de Youtube o Vimeo,
         entonces tendremos que hacer el GET dentro del POST y después enviarlo a videoMiner
          También tenemos que separar los POST de los GET, ya que las URIs son distintas*/

        return newChannel;
    }


}
