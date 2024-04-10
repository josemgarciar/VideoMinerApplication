package VimeoMiner.service;

import VimeoMiner.model.caption.CaptionList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import VimeoMiner.model.comments.Comment;
import VimeoMiner.model.comments.CommentsList;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    RestTemplate restTemplate;

    String baseUri = "https://api.vimeo.com/videos/903260788/comments";
    String token = "152307b18fa3949c3591a895137abe8e";

    public List<Comment> getComments(){
        HttpHeaders header = new HttpHeaders();
        header.set("Authorization", "bearer " + token);
        HttpEntity<CommentsList> request = new HttpEntity<>(null, header);

        ResponseEntity<CommentsList> response = restTemplate.exchange(baseUri, HttpMethod.GET, request, CommentsList.class);
        return response.getBody().getData();
    }

}


