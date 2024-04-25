package VimeoMiner.repository;

import VimeoMiner.model.video.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {

}
