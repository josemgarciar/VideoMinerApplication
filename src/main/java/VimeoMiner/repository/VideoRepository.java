package VimeoMiner.repository;

import VimeoMiner.model.video.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {

    List<Video> videos = new ArrayList<Video>();

    public default List<Video> findAll(){
        return videos;
    }

    public default Video findOne(String id){
        return videos.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    public default Video create(Video video){
        Video newVideo = new Video(video);
        videos.add(newVideo);
        return newVideo;
    }

    public default void update (Video updatedVideo, String id){
        Video existingVideo = findOne(id);
        int i = videos.indexOf(existingVideo);
        updatedVideo.setId(existingVideo.getId());
        videos.set(i, updatedVideo);
    }

    public default void delete(String id){
        videos.removeIf(c -> c.getId().equals(id));
    }

}
