package VimeoMiner.repository;

import VimeoMiner.model.channel.Channel;
import VimeoMiner.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> users = new ArrayList<User>();

    public default List<User> findAll() {
        return users;
    }

    public default User findOne(String id) {
        return users.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    public default User create(User user) {
        User newUser = new User(user);
        users.add(newUser);
        return newUser;
    }

    public default void update(User updatedUser, String id){
        User existing = findOne(id);
        int i = users.indexOf(existing);
        updatedUser.setId(existing.getId());
        users.set(i, updatedUser);
    }

    public default void delete(String id) {
        users.removeIf(c -> c.getId().equals(id));
    }
}
