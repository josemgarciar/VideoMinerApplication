package YoutubeMiner.service;

import YoutubeMiner.model.channel.Channel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChannelServiceTest {
    @Autowired
    YoutubeChannelService service;
    @Test
    void getChannel() {
        Channel res = service.getChannel();
        System.out.println(res);
    }
}