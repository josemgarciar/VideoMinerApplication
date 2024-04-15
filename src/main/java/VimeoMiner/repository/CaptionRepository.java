package VimeoMiner.repository;

import VimeoMiner.model.caption.TextTrack;
import VimeoMiner.model.channel.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;

@Repository
public interface CaptionRepository extends JpaRepository<TextTrack, Long> {

    List<TextTrack> textTracks = new ArrayList<TextTrack>();

    public default List<TextTrack> findAll() {
        return textTracks;
    }

    public default TextTrack findOne(String id) {
        return textTracks.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
    }

    public default TextTrack create(TextTrack t) {
        TextTrack newTextTrack = new TextTrack(t);
        textTracks.add(newTextTrack);
        return newTextTrack;
    }

    public default void update(TextTrack updatedTextTrack, String id){
        TextTrack existing = findOne(id);
        int i = textTracks.indexOf(existing);
        updatedTextTrack.setId(existing.getId());
        textTracks.set(i, updatedTextTrack);
    }
    public default void delete(String id){
        textTracks.removeIf(t -> t.getId().equals(id));
    }

}

