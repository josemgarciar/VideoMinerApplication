package VideoMiner.transforms;

import VideoMiner.model.Caption;
import VideoMiner.model.Comment;
import VideoMiner.model.User;
import VideoMiner.model.Video;
import YoutubeMiner.model.caption.CaptionSearch;
import YoutubeMiner.model.channel.ChannelSearch;
import YoutubeMiner.model.comment.CommentSearch;
import YoutubeMiner.model.video.VideoSnippet;
import YoutubeMiner.model.video.VideoSnippetSearch;
import exception.VideoWithoutCommentsException;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class youtube {

    static String tokenYT = "AIzaSyBSCMH5ASLuIxXKRN-_AV0ExAY_pr7GDiQ";
    static String baseUriYT ="https://www.googleapis.com/youtube/v3";
    static RestTemplate restTemplate = new RestTemplate();
    public static VideoMiner.model.Channel convertToChannel(ChannelSearch channelSearch, String id) throws VideoWithoutCommentsException {
        VideoMiner.model.Channel channel = new VideoMiner.model.Channel();
        channel.setId(channelSearch.getItems().get(0).getId());
        channel.setName(channelSearch.getItems().get(0).getSnippet().getTitle());
        channel.setDescription(channelSearch.getItems().get(0).getSnippet().getDescription());
        channel.setCreatedTime(channelSearch.getItems().get(0).getSnippet().getPublishedAt());
        channel.setVideos(videosDeCanal(id));
        return channel;
    }

    public static List<Video> videosDeCanal(String id) throws VideoWithoutCommentsException{
        HttpHeaders header = new HttpHeaders();
        HttpEntity<VideoSnippetSearch> request = new HttpEntity<>(null, header);
        String uri = baseUriYT + "/search" + "?key=" + tokenYT + "&channelId=" + id + "&part=snippet";
        ResponseEntity<VideoSnippetSearch> response =
                restTemplate.exchange(uri, HttpMethod.GET, request, VideoSnippetSearch.class);

        List<Video> videos = new ArrayList<>();

        for (VideoSnippet v : response.getBody().getItems()) {
            Video video = new Video();
            video.setId(v.getId().getVideoId());
            video.setName(v.getSnippet().getTitle());
            video.setDescription(v.getSnippet().getDescription());
            video.setReleaseTime(v.getSnippet().getPublishedAt());
            video.setComments(ComentariosDeVideo(v.getId().getVideoId()));
            video.setCaptions(CaptionsDeVideo(v.getId().getVideoId()));
            videos.add(video);
        }

        return videos;
    }
    public static List<Comment> ComentariosDeVideo(String id) throws VideoWithoutCommentsException {
        HttpHeaders header = new HttpHeaders();
        HttpEntity<CommentSearch> request = new HttpEntity<>(null, header);

        String uri = baseUriYT + "/commentThreads" + "?key=" + tokenYT + "&videoId=" + id + "&part=snippet";
        ResponseEntity<CommentSearch> response = restTemplate.exchange(uri, HttpMethod.GET, request, CommentSearch.class);

        List<Comment> comments = new ArrayList<>();

        if (response.getStatusCode() == HttpStatus.FORBIDDEN) {
            throw new VideoWithoutCommentsException();
        } else {
            for (YoutubeMiner.model.comment.Comment c : response.getBody().getItems()) {
                Comment comment = new Comment();
                User user  = new User();
                comment.setId(c.getCommentSnippet().getTopLevelComment().getId());
                comment.setCreatedOn(c.getCommentSnippet().getTopLevelComment().getSnippet().getPublishedAt());
                comment.setText(c.getCommentSnippet().getTopLevelComment().getSnippet().getTextOriginal());
                comment.setAuthor(AutorDeComentario(c.getCommentSnippet().getTopLevelComment().getSnippet().getAuthorDisplayName()));
                comments.add(comment);
            }
            return comments;
        }
    }
    private static User AutorDeComentario(String name) {
        User user = new User();
        user.setName(name);
        return user;
    }

    public static List<Caption> CaptionsDeVideo(String id) {
        HttpHeaders header = new HttpHeaders();
        header.set("Authorization", "bearer " + tokenYT);
        HttpEntity<VimeoMiner.model.caption.CaptionList> request = new HttpEntity<>(null, header);

        String uri = baseUriYT + "/captions?part=snippet&videoId=" + id + "&key=" + tokenYT;

        ResponseEntity<CaptionSearch> response = restTemplate.exchange(uri, HttpMethod.GET, request, CaptionSearch.class);

        List<VideoMiner.model.Caption> captions = new ArrayList<>();

        if (response.getBody().getItems().size() != 0){
            for (YoutubeMiner.model.caption.Caption captionYT : response.getBody().getItems()){
                Caption c = new Caption();
                c.setName(captionYT.getSnippet().getName());
                c.setId(captionYT.getId());
                c.setLanguage(captionYT.getSnippet().getLanguage());
                captions.add(c);
            }
        }
        return captions;
    }
}
