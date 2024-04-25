package VimeoMiner.repository;

import VimeoMiner.model.caption.TextTrack;
import VimeoMiner.model.channel.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;

@Repository
public interface CaptionRepository extends JpaRepository<TextTrack, Long> {

}

