package VimeoMiner.model.service;

import VimeoMiner.model.vimeo.video.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class VideoService {
    @Autowired
    RestTemplate restTemplate;
    String baseUri = "https://api.vimeo.com/channels/113480/videos";
    String token = "152307b18fa3949c3591a895137abe8e";

    public List<Example> getVideos() {
        HttpHeaders header = new HttpHeaders();
        header.set("Authorization", "bearer " + token);
        HttpEntity<Example[]> request = new HttpEntity<>(null, header);

        ResponseEntity<Example[]> response = restTemplate.exchange(baseUri, HttpMethod.GET, request, Example[].class);
        return List.of(response.getBody());
    }
}
