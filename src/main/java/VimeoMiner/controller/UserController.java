package VimeoMiner.controller;

import exception.UserNotFoundException;
import VimeoMiner.model.user.User;
import VimeoMiner.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("https://api.vimeo.com/comment/{id}/user")
public class UserController {


    @Autowired
    UserRepository repository;


    @GetMapping
    public List<User> getUsers() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public User findOne(@PathVariable Long id) throws UserNotFoundException {

        Optional<User> user = repository.findById(id);

        if(user.isEmpty()){
            throw new UserNotFoundException();
        }

        return user.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public User create(@Valid @RequestBody User user) {
        User newUser = repository.save(new User(user));

        return newUser;
    }

}
