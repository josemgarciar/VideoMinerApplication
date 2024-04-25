package VimeoMiner.repository;

import VimeoMiner.model.comments.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
