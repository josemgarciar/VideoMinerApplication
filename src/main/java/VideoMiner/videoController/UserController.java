package VideoMiner.videoController;

import VideoMiner.model.Comment;
import exception.UserNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import VideoMiner.model.User;
import VideoMiner.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Tag(name="Users", description = "Users operations")
@RestController
@RequestMapping("/videominer/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Operation(summary = "Find all Users", description = "Retrieve all users from VideoMiner", tags = { "Users", "Get operations"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Users from the database",
                    content = {@Content(schema = @Schema(implementation = Comment.class),
                            mediaType = "application/json")
                    }),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = {@Content(schema = @Schema())
                    })
    })
    @GetMapping
    public List<User> getUsers(@Parameter(description = "Name of the user. Used to search users by its name.") @RequestParam(required = false) String name,
                               @Parameter(description = "If present, determines the order of the response according to the parameter received.")@RequestParam(required = false) String order, // + o -
                               @Parameter(description = "Number of the response page. By default, VideoMiner will show the first page.")@RequestParam(defaultValue = "0") int page,
                               @Parameter(description = "Size of the response page. By default, VideoMiner will show five users per page.")@RequestParam(defaultValue = "5") int size) throws UserNotFoundException {


        Pageable paging;

        if (order != null) {
            if (order.startsWith("-"))
                paging = PageRequest.of(page, size, Sort.by(order.substring(1)).descending());
            else
                paging = PageRequest.of(page, size, Sort.by(order).ascending());
        } else {
            paging = PageRequest.of(page, size);
        }

        Page<User> pageUsers;

        if(name == null) {
            pageUsers = userRepository.findAll(paging);
        } else {
            pageUsers = userRepository.findByName(name, paging);
        }

        if(pageUsers.getContent().isEmpty()) {throw new UserNotFoundException();}
        return pageUsers.getContent();
    }

    @Operation(summary = "Find a user by id", description = "Find a user by id in VideoMiner", tags = { "Users", "Get operations"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "User from VideoMiner by its ID",
                    content = {@Content(schema = @Schema(implementation = Comment.class),
                            mediaType = "application/json")
                    }),

            @ApiResponse(responseCode = "404", description = "User not found",
                    content = {@Content(schema = @Schema())
                    })
    })
    @GetMapping("/{id}")
    public User findOne(@Parameter(description = "ID of the user to be searched")@PathVariable String id) throws UserNotFoundException {

        Optional<User> user = userRepository.findAll().stream().filter(u -> u.getId().equals(id)).findFirst();

        if(user.isEmpty()){
            throw new UserNotFoundException();
        }

        return user.get();
    }

    @Operation(summary = "Create a user", description = "Post a user to the database", tags = { "Users", "Post operations"})
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "User posted in the database",
                    content = {@Content(schema = @Schema(implementation = Comment.class),
                            mediaType = "application/json")
                    })
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public User create(@Parameter(description = "User to be posted in the database")@RequestBody User user) {
        userRepository.save(user);

        return user;
    }

    @Operation(summary = "Update a user", description = "Update user information given the user ID.", tags = { "Users", "Put operations"})
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "User updated",
                    content = {@Content(schema = @Schema())
                    }),

            @ApiResponse(responseCode = "404", description = "User not found",
                    content = {@Content(schema = @Schema())
                    })
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@Parameter(description = "ID of the user to be updated")@PathVariable Long id,
                       @Parameter(description = "Update User information given to user ID")@RequestBody User user) throws UserNotFoundException {
        Optional<User> foundUser = userRepository.findById(id);

        if(foundUser.isEmpty()){
            throw new UserNotFoundException();
        }

        foundUser.get().setName(user.getName());
        foundUser.get().setUser_link(user.getUser_link());
        foundUser.get().setPicture_link(user.getPicture_link());

        userRepository.save(user);
    }

    @Operation(summary = "Delete a user", description = "Delete a user from the database given the user ID", tags = { "Users", "Delete operations"})
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "User deleted",
                    content = {@Content(schema = @Schema())
                    }),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = {@Content(schema = @Schema())
                    })
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@Parameter(description = "ID of the user to be deleted")@PathVariable Long id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()){
            throw new UserNotFoundException();
        }

        userRepository.delete(user.get());
    }
}
