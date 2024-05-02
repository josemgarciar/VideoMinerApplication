package VideoMiner.videoController;

import VideoMiner.model.Channel;
import VideoMiner.model.Comment;
import VideoMiner.repository.CommentRepository;
import exception.ChannelNotFoundException;
import exception.CommentNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("https://localhost:8080/videominer/comments")
public class CommentController {
    @Autowired
    CommentRepository repository;

    @GetMapping
    public List<Comment> getChannels() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Comment findOne(@PathVariable Long id) throws CommentNotFoundException {

        Optional<Comment> comment = repository.findById(id);

        if(comment.isEmpty()){
            throw new CommentNotFoundException();
        }

        return comment.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Comment create(@Valid @RequestBody Comment comment) {
        Comment newComment = repository.save(new Comment(comment));
        return newComment;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @Valid @RequestBody Comment comment) throws CommentNotFoundException {
        Optional<Comment> foundComment = repository.findById(id);

        if(foundComment.isEmpty()){
            throw new CommentNotFoundException();
        }

        foundComment.get().setAuthor(comment.getAuthor());
        foundComment.get().setText(comment.getText());

        // No se actualiza porque el comentario ya fue creado en su momento
        // foundComment.get().setCreatedOn(comment.getCreatedOn());

        repository.save(comment);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws CommentNotFoundException {
        Optional<Comment> foundComment = repository.findById(id);

        if(foundComment.isEmpty()){
            throw new CommentNotFoundException();
        }

        repository.deleteById(id);
    }
}
