package VimeoMiner.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import VimeoMiner.model.channel.Channel;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChannelServiceTest {
    @Autowired ChannelService service;
    @Test
    void getChannel() {
        Channel res = service.getChannel();
        System.out.println(res);
    }
}