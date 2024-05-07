package VideoMiner.videoController;

import VideoMiner.model.Caption;
import VideoMiner.model.Channel;
import VideoMiner.model.Comment;
import VideoMiner.repository.CommentRepository;
import exception.ChannelNotFoundException;
import exception.CommentNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Tag(name="Comments", description = "Comments operations")
@RestController
@RequestMapping("/videominer/comments")
public class CommentController {
    @Autowired
    CommentRepository repository;

    @Operation(summary = "Find all comments", description = "Retrieve all comments from VideoMiner", tags = { "Comments", "Get operations"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Captions from the database",
                    content = {@Content(schema = @Schema(implementation = Comment.class),
                            mediaType = "application/json")
                    })
    })
    @GetMapping
    public List<Comment> getComments(@Parameter(description = "Name of the comment. Used to search comments by its name.") @RequestParam(required = false) String name,
                                     @Parameter(description = "If present, determines the order of the response according to the parameter received.")@RequestParam(required = false) String order, // + o -
                                     @Parameter(description = "Number of the response page. By default, VideoMiner will show the first page.")@RequestParam(defaultValue = "0") int page,
                                     @Parameter(description = "Size of the response page. By default, VideoMiner will show five comments per page.")@RequestParam(defaultValue = "5") int size) {

        Pageable paging;

        if (order != null) {
            if (order.startsWith("-"))
                paging = PageRequest.of(page, size, Sort.by(order.substring(1)).descending());
            else
                paging = PageRequest.of(page, size, Sort.by(order).ascending());
        } else {
            paging = PageRequest.of(page, size);
        }

        Page<Comment> pageComments;

        if(name == null) {
            pageComments = repository.findAll(paging);
        } else {
            pageComments = repository.findByName(name, paging); //TODO: Hay que probar como funciona (o si funciona) el findByName, ya que comments no tiene name.
        }
        return pageComments.getContent();
    }

    @Operation(summary = "Find a comment by id", description = "Find a comment by id in VideoMiner", tags = { "Comments", "Get operations"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Comment from VideoMiner by its ID",
                    content = {@Content(schema = @Schema(implementation = Comment.class),
                            mediaType = "application/json")
                    }),

            @ApiResponse(responseCode = "404", description = "Comment not found",
                    content = {@Content(schema = @Schema())
                    })
    })
    @GetMapping("/{id}")
    public Comment findOne(@Parameter(description = "ID of the comment to be searched")@PathVariable String id) throws CommentNotFoundException {

        Optional<Comment> comment = repository.findAll().stream().filter(x -> x.getId().equals(id)).findFirst();

        if(comment.isEmpty()){
            throw new CommentNotFoundException();
        }

        return comment.get();
    }

    @Operation(summary = "Create a comment", description = "Post a comment to the database", tags = { "Comments", "Post Operations"})
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Comment posted in the database",
                    content = {@Content(schema = @Schema(implementation = Comment.class),
                            mediaType = "application/json")
                    })
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Comment create(@Parameter(description = "Comment to be posted in the database")@Valid @RequestBody Comment comment) {
        repository.save(comment);
        return comment;
    }

    @Operation(summary = "Update a comment", description = "Update comment information given the comment ID.", tags = { "Comments", "Put Operations"})
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Comment updated",
                    content = {@Content(schema = @Schema())
                    }),

            @ApiResponse(responseCode = "404", description = "Comment not found",
                    content = {@Content(schema = @Schema())
                    })
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@Parameter(description = "ID of the comment to be updated") @PathVariable String id,
                       @Parameter(description = "Comment object with the updated information")@Valid @RequestBody Comment comment) throws CommentNotFoundException {
        Optional<Comment> foundComment = repository.findAll().stream().filter(c -> c.getId().equals(id)).findFirst();

        if(foundComment.isEmpty()){
            throw new CommentNotFoundException();
        }

        foundComment.get().setAuthor(comment.getAuthor());
        foundComment.get().setText(comment.getText());

        // No se actualiza porque el comentario ya fue creado en su momento
        // foundComment.get().setCreatedOn(comment.getCreatedOn());

        repository.save(comment);
    }

    @Operation(summary = "Delete a comment", description = "Delete a comment from the database given the comment ID", tags = { "Comments", "Delete Operations"})
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Comment deleted",
                    content = {@Content(schema = @Schema())
                    }),
            @ApiResponse(responseCode = "404", description = "Comment not found",
                    content = {@Content(schema = @Schema())
                    })
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@Parameter(description = "ID of the comment to be deleted")@PathVariable Long id) throws CommentNotFoundException {
        Optional<Comment> foundComment = repository.findById(id);

        if(foundComment.isEmpty()){
            throw new CommentNotFoundException();
        }

        repository.deleteById(id);
    }
}
