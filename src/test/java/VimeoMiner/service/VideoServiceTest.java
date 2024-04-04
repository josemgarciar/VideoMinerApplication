package VimeoMiner.service;

import VimeoMiner.model.video.Video;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class VideoServiceTest {

    @Autowired VideoService service;

    @Test
    void getVideos() {
        List<Video> res = service.getVideos();
        System.out.println(res);
    }
}