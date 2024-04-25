package VimeoMiner.repository;

import VimeoMiner.model.channel.Channel;
import VimeoMiner.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
