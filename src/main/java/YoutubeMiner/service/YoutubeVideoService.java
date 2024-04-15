package YoutubeMiner.service;

import YoutubeMiner.model.video.VideoSnippet;
import YoutubeMiner.model.video.VideoSnippetSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class YoutubeVideoService {
    @Autowired
    RestTemplate restTemplate;

    String baseUri = "https://www.googleapis.com/youtube/v3/search?key=AIzaSyBSCMH5ASLuIxXKRN-_AV0ExAY_pr7GDiQ&channelId=UC8rNKrqBxJqL9izOOMxBJtw&part=snippet";
    public VideoSnippetSearch getVideo(){
        HttpHeaders header = new HttpHeaders();
        HttpEntity<VideoSnippetSearch> request = new HttpEntity<>(null, header);
        ResponseEntity<VideoSnippetSearch> response = restTemplate.exchange(baseUri, HttpMethod.GET, request, VideoSnippetSearch.class);
        return response.getBody();
    }

}
