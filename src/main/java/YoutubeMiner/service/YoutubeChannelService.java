package YoutubeMiner.service;

import YoutubeMiner.model.channel.Channel;
import YoutubeMiner.model.channel.ChannelSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class YoutubeChannelService {
    @Autowired
    RestTemplate restTemplate;

    String baseUri = "https://www.googleapis.com/youtube/v3/channels?key=AIzaSyBSCMH5ASLuIxXKRN-_AV0ExAY_pr7GDiQ&forUsername=Willyrex&part=snippet";

    public Channel getChannel() {
        HttpHeaders header = new HttpHeaders();
        HttpEntity<ChannelSearch> request = new HttpEntity<>(null, header);
        ResponseEntity<ChannelSearch> response = restTemplate.exchange(baseUri, HttpMethod.GET, request, ChannelSearch.class);
        return response.getBody().getItems().get(0);
    }
}
