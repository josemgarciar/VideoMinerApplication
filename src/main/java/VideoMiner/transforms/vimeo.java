package VideoMiner.transforms;

import VideoMiner.model.*;
import VimeoMiner.model.comments.CommentsList;
import VimeoMiner.model.video.VideoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class vimeo {

    String baseUriVimeo = "https://api.vimeo.com/channels/";

    String tokenVimeo = "152307b18fa3949c3591a895137abe8e";
    RestTemplate restTemplate = new RestTemplate();

    public Channel convertToChannel(ResponseEntity<VimeoMiner.model.channel.Channel> response, String id) {
        Channel channelDB = new Channel();
        channelDB.setId(response.getBody().getId());
        channelDB.setDescription(response.getBody().getDescription());
        channelDB.setName(response.getBody().getName());
        channelDB.setCreatedTime(response.getBody().getCreatedTime());
        channelDB.setVideos(videosDeCanal(id));
        return channelDB;
    }

    public List<Video> videosDeCanal(String id){
        HttpHeaders header = new HttpHeaders();
        header.set("Authorization", "bearer " + tokenVimeo);
        HttpEntity<VideoList> request = new HttpEntity<>(null, header);
        ResponseEntity<VideoList> response = restTemplate.exchange(baseUriVimeo + id + "/videos", HttpMethod.GET, request, VideoList.class);

        List<VimeoMiner.model.video.Video> videosSinTransformar = response.getBody().getData();

        List<Video> videos = new ArrayList<>();

        for (VimeoMiner.model.video.Video video : videosSinTransformar) {
            Video videoDB = new Video();
            videoDB.setId(video.getId());
            videoDB.setDescription(video.getDescription());
            videoDB.setName(video.getName());
            videoDB.setReleaseTime(video.getReleaseTime());
            videoDB.setComments(ComentariosDeVideo(video.getId()));
            videoDB.setCaptions(CaptionsDeVideo(video.getId()));
            videos.add(videoDB);
        }
        return videos;
    }
    public List<Comment> ComentariosDeVideo(String id) {
        HttpHeaders header = new HttpHeaders();
        header.set("Authorization", "bearer " + tokenVimeo);
        HttpEntity<CommentsList> request = new HttpEntity<>(null, header);

        String uri = "https://api.vimeo.com/videos/";

        ResponseEntity<CommentsList> response = restTemplate.exchange(uri + id + "/comments" , HttpMethod.GET, request, CommentsList.class);

        List<Comment> comments = new ArrayList<>();
        for(VimeoMiner.model.comments.Comment comment: response.getBody().getData()){

            VideoMiner.model.Comment commentDB = new VideoMiner.model.Comment();
            commentDB.setId(comment.getId());
            commentDB.setText(comment.getText());
            commentDB.setCreatedOn(comment.getCreatedOn());
            commentDB.setAuthor(autorComentario(comment.getUser()));
            comments.add(commentDB);
        }

        return comments;


    }

    public List<Caption> CaptionsDeVideo(String id) {
        HttpHeaders header = new HttpHeaders();
        header.set("Authorization", "bearer " + tokenVimeo);
        HttpEntity<VimeoMiner.model.caption.CaptionList> request = new HttpEntity<>(null, header);

        String uri = "https://api.vimeo.com/videos/";

        ResponseEntity<VimeoMiner.model.caption.CaptionList> response = restTemplate.exchange(uri + id + "/texttracks", HttpMethod.GET, request, VimeoMiner.model.caption.CaptionList.class);

        List<VideoMiner.model.Caption> captions = new ArrayList<>();

        if (response.getBody().getData().size() != 0){
            for (VimeoMiner.model.caption.TextTrack textTrack : response.getBody().getData()) {
                Caption captionDB = new Caption();
                captionDB.setLanguage(textTrack.getLanguage());
                captionDB.setName(textTrack.getName());
                captionDB.setId(textTrack.getId());
                captions.add(captionDB);
            }
        }
        return captions;
    }

    public User autorComentario(VimeoMiner.model.user.User user) {
        User userDB = new User();
        userDB.setId(Long.valueOf(user.getId()));
        userDB.setName(user.getName());
        userDB.setPicture_link(user.getLink());
        return userDB;
    }
}
