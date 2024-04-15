package VimeoMiner.service;

import VimeoMiner.model.caption.TextTrack;
import VimeoMiner.model.channel.Channel;
import VimeoMiner.model.comments.Comment;
import VimeoMiner.model.user.User;
import VimeoMiner.model.video.Video;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ServiceTest {
    @Autowired CaptionService serviceCaption;

    @Test
    void getCaptions() {
        List<TextTrack> res = serviceCaption.getCaptions();
        System.out.println(res);
    }

    @Autowired
    ChannelService serviceChannel;
    @Test
    void getChannel() {
        Channel res = serviceChannel.getChannel();
        System.out.println(res);
    }

    @Autowired CommentService serviceComments;
    @Test
    void getComments() {
        List<Comment> res = serviceComments.getComments();
        System.out.println(res);
    }

    @Autowired
    UserService serviceUser;

    @Test
    void getUser() {
        User res = serviceUser.getUser();
        System.out.println(res);
    }

    @Autowired VideoService serviceVideos;

    @Test
    void getVideos() {
        List<Video> res = serviceVideos.getVideos();
        System.out.println(res);
    }
}
