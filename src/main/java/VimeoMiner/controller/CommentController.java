package VimeoMiner.controller;

import exception.CommentNotFoundException;
import VimeoMiner.model.comments.Comment;
import VimeoMiner.repository.CommentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("https://api.vimeo.com/video/{id}/comment")
public class CommentController {


    @Autowired
    CommentRepository repository;


    @GetMapping
    public List<Comment> getComments() {
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
}
