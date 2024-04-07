package VimeoMiner.service;

import VimeoMiner.model.caption.TextTrack;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CaptionServiceTest {
    @Autowired CaptionService service;

    @Test
    void getCaptions() {
        List<TextTrack> res = service.getCaptions();
        System.out.println(res);
    }
}