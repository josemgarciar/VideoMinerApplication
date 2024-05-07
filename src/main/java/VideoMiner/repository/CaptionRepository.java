package VideoMiner.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import VideoMiner.model.Caption;

@Repository
public interface CaptionRepository extends JpaRepository<Caption,Long> {
    Page<Caption> findByName(String name, Pageable pageable);
    Page<Caption> findAll(Pageable pageable);
}
