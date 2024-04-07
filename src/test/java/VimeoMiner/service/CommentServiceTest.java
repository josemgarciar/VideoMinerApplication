package VimeoMiner.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import VimeoMiner.model.comments.Comment;

import java.util.List;

@SpringBootTest
class CommentServiceTest {
    @Autowired CommentService service;
    @Test
    void getComments() {
        List<Comment> res = service.getComments();
        System.out.println(res);
    }

}