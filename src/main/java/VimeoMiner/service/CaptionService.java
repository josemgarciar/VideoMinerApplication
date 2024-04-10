package VimeoMiner.service;

import VimeoMiner.model.caption.CaptionList;
import VimeoMiner.model.caption.TextTrack;
import VimeoMiner.model.video.Video;
import VimeoMiner.model.video.VideoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CaptionService {
    @Autowired
    RestTemplate restTemplate;
    String baseUri = "https://api.vimeo.com/videos/903260788/texttracks";
    String token = "152307b18fa3949c3591a895137abe8e";

    public List<TextTrack> getCaptions() {
        HttpHeaders header = new HttpHeaders();
        header.set("Authorization", "bearer " + token);
        HttpEntity<CaptionList> request = new HttpEntity<>(null, header);

        ResponseEntity<CaptionList> response = restTemplate.exchange(baseUri, HttpMethod.GET, request, CaptionList.class);
        return response.getBody().getData();
    }
}
