package YoutubeMiner.service;

import VimeoMiner.model.comments.Comment;
import YoutubeMiner.model.comment.CommentSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class YoutubeCommentService {

    @Autowired
    RestTemplate restTemplate;
    String baseUri = "https://www.googleapis.com/youtube/v3/commentThreads?part=snippet&videoId=3mFwBZyiSn4&key=AIzaSyBSCMH5ASLuIxXKRN-_AV0ExAY_pr7GDiQ";

    public CommentSearch getComment(){
        HttpHeaders header = new HttpHeaders();
        HttpEntity<CommentSearch> request = new HttpEntity<>(null, header);
        ResponseEntity<CommentSearch> response = restTemplate.exchange(baseUri, HttpMethod.GET, request, CommentSearch.class);
        return response.getBody();
    }
}

