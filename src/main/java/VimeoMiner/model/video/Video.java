
package VimeoMiner.model.video;

import VimeoMiner.etl.ParseId;
import VimeoMiner.model.caption.TextTrack;
import VimeoMiner.model.channel.Channel;
import VimeoMiner.model.comments.CommentsList;
import YoutubeMiner.model.comment.Comment;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Video {

    private String id;
    @JsonProperty("uri")
    private String uri;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("release_time")
    private String releaseTime;

    // These attributes have been manually added
    @JsonProperty("comments")
    private CommentsList comments;

    @JsonProperty("captions")
    private List<TextTrack> captions;


    public Video (Video param){
        this.uri = param.getUri();
        this.name = param.getName();
        this.description = param.getDescription();
        this.description = param.getDescription();
        this.releaseTime = param.getReleaseTime();
        this.comments = param.getComments();
        this.captions = param.getCaptions();
    }

    @JsonProperty("comments")
    public CommentsList getComments() {
        return comments;
    }

    @JsonProperty("comments")
    public void setComments(CommentsList comments) {
        this.comments = comments;
    }

    @JsonProperty("captions")
    public List<TextTrack> getCaptions() { return captions; }

    @JsonProperty("captions")
    public void setCaptions(List<TextTrack> captions) {
        this.captions = captions;
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

    @JsonProperty("release_time")
    public String getReleaseTime() {
        return releaseTime;
    }

    @JsonProperty("release_time")
    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getId(){
        return ParseId.getIdFromUri(this.uri);
    }
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
        sb.append(',');
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
        sb.append(((this.releaseTime == null)?"<null>":this.releaseTime));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
