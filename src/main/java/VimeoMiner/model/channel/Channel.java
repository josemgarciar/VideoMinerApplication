package VimeoMiner.model.channel;

import VimeoMiner.etl.ParseId;
import VimeoMiner.model.video.Video;
import YoutubeMiner.model.video.VideoSnippet;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Channel {

    private String id;
    @JsonProperty("uri")
    private String uri;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("created_time")
    private String createdTime;

    // This attribute has been added manually

    @JsonProperty("videos")
    private List<Video> videos;

    public Channel() {
        videos = new ArrayList<>();
    }

    public Channel (Channel param){
        this.uri = param.getUri();
        this.name = param.getName();
        this.description = param.getDescription();
        this.createdTime = param.getCreatedTime();
        this.videos = new ArrayList<>(); //JRP: The list of videos is empty by default
    }

    @JsonProperty("videos")
    public List<Video> getVideos(){ return videos; }

    @JsonProperty("videos")
    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    @JsonProperty("uri")
    public String getUri() {
        return uri;
    }

    @JsonProperty("uri")
    public void setUri(String uri) {
        this.uri = uri;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("created_time")
    public String getCreatedTime() {
        return createdTime;
    }

    @JsonProperty("created_time")
    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getId() {return ParseId.getIdFromUri(this.uri);}

    public void setId(String Id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Video.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((getId() == null)?"<null>":getId()));
        sb.append((","));
        sb.append("uri");
        sb.append('=');
        sb.append(((this.uri == null)?"<null>":this.uri));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        sb.append("releaseTime");
        sb.append('=');
        sb.append(((this.createdTime == null)?"<null>":this.createdTime));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }
}
