package YoutubeMiner.service;

import VideoMiner.model.Video;
import YoutubeMiner.model.caption.CaptionSearch;
import YoutubeMiner.model.channel.Channel;
import YoutubeMiner.model.comment.CommentSearch;
import YoutubeMiner.model.video.VideoSnippetSearch;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ServiceTest {

    @Autowired
    YoutubeChannelService serviceChannel;

    @Test
    void getChannel() {
        VideoMiner.model.Channel res = serviceChannel.getChannel();
        System.out.println(res);
    }

    @Autowired
    YoutubeVideoService serviceVideo;
    @Test
    void getVideo() {
        List<Video> res = serviceVideo.getVideo();
        System.out.println(res);
    }

    @Autowired
    YoutubeCommentService serviceComment;

    @Test
    void getComment() {
        CommentSearch res = serviceComment.getComment();
        System.out.println(res);
    }

    @Autowired
    YoutubeCaptionService serviceCaption;

    @Test
    void getCaption() {
        CaptionSearch res = serviceCaption.getCaption();
        System.out.println(res);
    }

}
