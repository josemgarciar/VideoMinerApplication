package YoutubeMiner.repository;

import YoutubeMiner.model.caption.Caption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaptionRepository extends JpaRepository<Caption, Long> {
}
