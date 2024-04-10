package YoutubeMiner.service;

import YoutubeMiner.model.video.Video;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class YoutubeVideoServiceTest {
    @Autowired
    YoutubeVideoService service;
    @Test
    void getVideo() {
        Video res = service.getVideo();
        System.out.println(res);
    }
}