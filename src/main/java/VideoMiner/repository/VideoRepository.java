package VideoMiner.repository;

import VideoMiner.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import VideoMiner.model.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
    Page<Video> findByName(String name, Pageable pageable);
    Page<Video> findAll(Pageable pageable);
}
