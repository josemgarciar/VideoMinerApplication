package VimeoMiner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import VimeoMiner.model.channel.Channel;

@Service
public class ChannelService {
    @Autowired
    RestTemplate restTemplate;
    String baseUri = "https://api.vimeo.com/channels/113480";
    String token = "152307b18fa3949c3591a895137abe8e";

    public Channel getChannel() {
        HttpHeaders header = new HttpHeaders();
        header.set("Authorization", "bearer " + token);
        HttpEntity<Channel> request = new HttpEntity<>(null, header);

        ResponseEntity<Channel> response = restTemplate.exchange(baseUri, HttpMethod.GET, request, Channel.class);
        return response.getBody();
    }
}
