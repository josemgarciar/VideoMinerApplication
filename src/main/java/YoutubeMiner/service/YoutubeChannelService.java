package YoutubeMiner.service;

import YoutubeMiner.model.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class YoutubeChannelService {
    @Autowired
    RestTemplate restTemplate;

    String baseUri = "https://www.googleapis.com/youtube/v3/channels?key=AIzaSyBSCMH5ASLuIxXKRN-_AV0ExAY_pr7GDiQ&forUsername=Willyrex&part=snippet";

    public Channel getChannel() {
        HttpHeaders header = new HttpHeaders();
        HttpEntity<ChannelList> request = new HttpEntity<>(null, header);
        ResponseEntity<ChannelList> response = restTemplate.exchange(baseUri, HttpMethod.GET, request, ChannelList.class);
        return response.getBody().getItems().get(0);
    }
}
