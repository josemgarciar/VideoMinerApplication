package VideoMiner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import VideoMiner.model.Caption;

@Repository
public interface CaptionRepository extends JpaRepository<Caption,Long> {
}
