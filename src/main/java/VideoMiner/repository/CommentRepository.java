package VideoMiner.repository;
import VideoMiner.model.Caption;
import VideoMiner.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Page<Comment> findByName(String name, Pageable pageable);
    Page<Comment> findAll(Pageable pageable);
}
