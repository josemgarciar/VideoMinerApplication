package VimeoMiner.repository;

import VimeoMiner.model.comments.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> comments = new ArrayList<Comment>();

    public default List<Comment> findAll() {
        return comments;
    }

    public default Comment findOne(String id) {
        return comments.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    public default Comment create(Comment comment) {
        Comment newComment = new Comment(comment);
        comments.add(newComment);
        return newComment;
    }

    public default void update(Comment updatedComment, String id){
        Comment existing = findOne(id);
        int i = comments.indexOf(existing);
        updatedComment.setId(existing.getId());
        comments.set(i, updatedComment);
    }

    public default void delete(String id) {
        comments.removeIf(c -> c.getId().equals(id));
    }
}
