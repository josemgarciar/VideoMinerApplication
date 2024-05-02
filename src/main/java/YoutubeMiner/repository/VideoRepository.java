package YoutubeMiner.repository;

import YoutubeMiner.model.video.VideoSnippet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<VideoSnippet,Long> {
}
