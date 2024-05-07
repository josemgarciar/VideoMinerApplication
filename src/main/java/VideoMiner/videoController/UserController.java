package VideoMiner.videoController;

import VideoMiner.model.Comment;
import exception.UserNotFoundException;
import io.swagger.v3.oas.annotations.Parameter;
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

@RestController
@RequestMapping("/videominer/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<User> getUsers(@Parameter(description = "Name of the comment. Used to search users by its name.") @RequestParam(required = false) String name,
                               @Parameter(description = "If present, determines the order of the response according to the parameter received.")@RequestParam(required = false) String order, // + o -
                               @Parameter(description = "Number of the response page. By default, VideoMiner will show the first page.")@RequestParam(defaultValue = "0") int page,
                               @Parameter(description = "Size of the response page. By default, VideoMiner will show five users per page.")@RequestParam(defaultValue = "5") int size) {


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
        return pageUsers.getContent();
    }

    @GetMapping("/{id}")
    public User findOne(@PathVariable String id) throws UserNotFoundException {

        Optional<User> user = userRepository.findAll().stream().filter(u -> u.getId().equals(id)).findFirst();

        if(user.isEmpty()){
            throw new UserNotFoundException();
        }

        return user.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public User create(@RequestBody User user) {
        userRepository.save(user);

        return user;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody User user) throws UserNotFoundException {
        Optional<User> foundUser = userRepository.findById(id);

        if(foundUser.isEmpty()){
            throw new UserNotFoundException();
        }

        foundUser.get().setName(user.getName());
        foundUser.get().setUser_link(user.getUser_link());
        foundUser.get().setPicture_link(user.getPicture_link());

        userRepository.save(user);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()){
            throw new UserNotFoundException();
        }

        userRepository.delete(user.get());
    }
}
