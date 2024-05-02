package YoutubeMiner.controller;

import YoutubeMiner.model.channel.Channel;
import YoutubeMiner.model.video.VideoSnippet;
import YoutubeMiner.model.comment.Comment;
import YoutubeMiner.repository.ChannelRepository;
import YoutubeMiner.repository.CommentRepository;
import YoutubeMiner.repository.VideoRepository;
import exception.ChannelNotFoundException;
import exception.VideoNotFoundException;
import exception.VideoWithoutCommentsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("https://www.googleapis.com/youtube/v3/commentThreads?part=snippet")
public class CommentController {
    @Autowired
    CommentRepository commentRepository;
    VideoRepository videoRepository;
    ChannelRepository channelRepository;

    @GetMapping("&videoId={id}")
    public List<Comment> getAllCommentsByVideoId(@PathVariable Long id) throws VideoNotFoundException, VideoWithoutCommentsException {
        Optional<VideoSnippet> video = videoRepository.findById(id);

        if(video.isEmpty()){
            throw new VideoNotFoundException();
        }

        if(video.get().getComments().isEmpty()){
            throw new VideoWithoutCommentsException();
        }
        return video.get().getComments();
    }

    @GetMapping("&allThreadsRelatedToChannelId={id}")
    public List<List<Comment>> getAllCommentsByChannelId(@PathVariable Long id) throws ChannelNotFoundException, VideoWithoutCommentsException {
        Optional<Channel> channel = channelRepository.findById(id);
        List<List<Comment>> res = new ArrayList<>();

        if(channel.isEmpty()){
            throw new ChannelNotFoundException();
        }

        if(channel.get().getVideos().stream().allMatch(v -> v.getComments() == null)){
            throw new VideoWithoutCommentsException();
        }

        for(VideoSnippet v : channel.get().getVideos()){
            res.add(v.getComments());
        }
        return res;
    }

    @PostMapping
    public Comment create (@RequestBody Comment comment){
        Comment newComment = commentRepository.save(comment);
        /*Además, el canal que mandemos no nos llega como parámetro, sino que lo cogemos de la API de Youtube o Vimeo,
         entonces tendremos que hacer el GET dentro del POST y después enviarlo a videoMiner */

        return newComment;
    }






}
