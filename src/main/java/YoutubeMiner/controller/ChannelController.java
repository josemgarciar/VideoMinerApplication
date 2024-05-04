package YoutubeMiner.controller;

import VideoMiner.repository.VideoRepository;
import VimeoMiner.model.video.Video;
import YoutubeMiner.model.caption.Caption;
import YoutubeMiner.model.caption.CaptionSnippet;
import YoutubeMiner.model.comment.Comment;
import YoutubeMiner.model.video.VideoSnippet;
import YoutubeMiner.service.YoutubeChannelService;
import exception.ChannelNotFoundException;
import YoutubeMiner.model.channel.Channel;
import YoutubeMiner.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
// @RequestMapping("https://www.googleapis.com/youtube/v3/channels")
public class ChannelController {



    @Autowired
    ChannelRepository channelRepository;
    @Autowired
    YoutubeChannelService service;

    @Autowired
    RestTemplate restTemplate;


    @GetMapping
    public List<Channel> getChannels(){
        return channelRepository.findAll();
    }
    @GetMapping("&channelId={id}")
    public Channel findOne(@PathVariable Long id) throws ChannelNotFoundException {
        Optional<Channel> foundChannel = channelRepository.findById(id);

        if(foundChannel.isEmpty()){
            throw new ChannelNotFoundException();
        }

        return foundChannel.get();
    }

    @PostMapping() //La URI del POST maping es la de nuestra API. Ídem para todos los POST de todos los controllers de Vimeo y Youtube
    public VideoMiner.model.Channel create() throws  ChannelNotFoundException {

        Channel channel = service.getChannel();

        VideoMiner.model.Channel newChannel = new VideoMiner.model.Channel();

        newChannel.setDescription(channel.getSnippet().getDescription());
        newChannel.setName(channel.getSnippet().getTitle());
        newChannel.setCreatedTime(channel.getSnippet().getPublishedAt());
        newChannel.setId(channel.getId());



       // channelRepository.save(channel);

        HttpEntity<VideoMiner.model.Channel> req = new HttpEntity<>(newChannel);

        ResponseEntity<VideoMiner.model.Channel> resp = restTemplate.exchange("http://localhost:8080/videominer/channels", HttpMethod.POST, req, VideoMiner.model.Channel.class);

        return resp.getBody();









//        Channel newChannel = findOne(id);
//        List<VideoSnippet> videos = newChannel.getVideos();
//        List<Caption> captions = new ArrayList<>();
//        List<Comment> comments = new ArrayList<>();
//        List<User> users = new ArrayList<>();
//
//        for (VideoSnippet v : videos) {
//            captions.addAll(v.getCaptions());
//            comments.addAll(v.getComments());
//        }
//
//        for (Comment c : comments) {
//            users.add(c.getCommentSnippet().getTopLevelComment().getSnippet().);
//        }


        /*Además, el canal que mandemos no nos llega como parámetro, sino que lo cogemos de la API de Youtube o Vimeo,
         entonces tendremos que hacer el GET dentro del POST y después enviarlo a videoMiner
          También tenemos que separar los POST de los GET, ya que las URIs son distintas*/

    }


}
