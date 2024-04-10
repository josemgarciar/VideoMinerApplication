package YoutubeMiner.service;

import YoutubeMiner.model.video.Video;
import YoutubeMiner.model.video.VideoList;
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

    String baseUri = "https://www.googleapis.com/youtube/v3/videos?part=snippet%2CcontentDetails%2Cstatistics&id=tcdKEy-aJ6o&key=AIzaSyBSCMH5ASLuIxXKRN-_AV0ExAY_pr7GDiQ";
    public Video getVideo(){
        HttpHeaders header = new HttpHeaders();
        HttpEntity<VideoList> request = new HttpEntity<>(null, header);
        ResponseEntity<VideoList> response = restTemplate.exchange(baseUri, HttpMethod.GET, request, VideoList.class);
        return response.getBody().getItems().get(0);
    }

}
