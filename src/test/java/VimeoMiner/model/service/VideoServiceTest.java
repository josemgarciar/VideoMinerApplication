package VimeoMiner.model.service;

import VimeoMiner.model.vimeo.video.Example;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class VideoServiceTest {

    @Autowired VideoService service;

    @Test
    void getVideos() {
        List<Example> res = service.getVideos();
        System.out.println(res);
    }
}