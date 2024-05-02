package VideoMiner.videoController;

import exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import VideoMiner.model.User;
import VideoMiner.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("https://localhost:8080/videominer/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User findOne(@PathVariable Long id) throws UserNotFoundException {

        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()){
            throw new UserNotFoundException();
        }

        return user.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public User create(@RequestBody User user) {
        User newUser = userRepository.save(new User(user));

        return newUser;
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
