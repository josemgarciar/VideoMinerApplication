package YoutubeMiner.service;

import YoutubeMiner.model.caption.CaptionSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class YoutubeCaptionService {
    @Autowired
    RestTemplate restTemplate;
    String baseUri ="https://youtube.googleapis.com/youtube/v3/captions?part=snippet&videoId=M7FIvfx5J10&key=AIzaSyBSCMH5ASLuIxXKRN-_AV0ExAY_pr7GDiQ";

    public CaptionSearch getCaption(){
        HttpHeaders header = new HttpHeaders();
        HttpEntity<CaptionSearch> request = new HttpEntity<>(null, header);
        ResponseEntity<CaptionSearch> response = restTemplate.exchange(baseUri, HttpMethod.GET, request, CaptionSearch.class);
        return response.getBody();
    }
}
