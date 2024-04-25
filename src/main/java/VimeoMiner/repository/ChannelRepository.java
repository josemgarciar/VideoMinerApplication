package VimeoMiner.repository;

import VimeoMiner.model.channel.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {

}
