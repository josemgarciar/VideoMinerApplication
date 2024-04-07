package VimeoMiner.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import VimeoMiner.model.user.User;
@SpringBootTest
class UserServiceTest {
    @Autowired
    UserService service;

    @Test
    void getUser() {
        User res = service.getUser();
        System.out.println(res);
    }
}