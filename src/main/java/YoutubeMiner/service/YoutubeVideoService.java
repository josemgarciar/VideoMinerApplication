package YoutubeMiner.service;

import VideoMiner.model.Video;
import YoutubeMiner.model.video.VideoSnippet;
import YoutubeMiner.model.video.VideoSnippetSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class YoutubeVideoService {

    RestTemplate restTemplate = new RestTemplate();
    String baseUri = "https://www.googleapis.com/youtube/v3/search?key=AIzaSyBSCMH5ASLuIxXKRN-_AV0ExAY_pr7GDiQ&channelId=UC8rNKrqBxJqL9izOOMxBJtw&part=snippet";
    public List<Video> getVideo(){
        HttpHeaders header = new HttpHeaders();
        HttpEntity<VideoSnippetSearch> request = new HttpEntity<>(null, header);
        ResponseEntity<VideoSnippetSearch> response = restTemplate.exchange(baseUri, HttpMethod.GET, request, VideoSnippetSearch.class);

        List<Video> videos = new ArrayList<>();
        if(response == null){
            return null;
        }else{
            for (VideoSnippet videoSnippet : response.getBody().getItems()) {
                videos.add(convertToDBVideo(videoSnippet));
            }
        }
        return videos;
    }

    private VideoMiner.model.Video convertToDBVideo(VideoSnippet videoSnippet){
        Video newVid = new Video();
        newVid.setId(videoSnippet.getId().getVideoId());
        newVid.setName(videoSnippet.getSnippet().getTitle());
        newVid.setDescription(videoSnippet.getSnippet().getDescription());
        newVid.setReleaseTime(videoSnippet.getSnippet().getPublishedAt());
        return newVid;
    }
}
