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
    List<Channel> channels = new ArrayList<Channel>();

    public default List<Channel> findAll() {
        return channels;
    }

    public default Channel findOne(String id) {
        return channels.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    public default Channel create(Channel channel) {
        Channel newChannel = new Channel(channel);
        channels.add(newChannel);
        return newChannel;
    }

    public default void update(Channel updatedChannel, String id){
        Channel existing = findOne(id);
        int i = channels.indexOf(existing);
        updatedChannel.setId(existing.getId());
        channels.set(i, updatedChannel);
    }

    public default void delete(String id) {
        channels.removeIf(c -> c.getId().equals(id));
    }
}
