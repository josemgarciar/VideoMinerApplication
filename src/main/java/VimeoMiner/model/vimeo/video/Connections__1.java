
package VimeoMiner.model.vimeo.video;;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "comments",
    "credits",
    "likes",
    "pictures",
    "texttracks",
    "related",
    "recommendations",
    "albums",
    "available_albums",
    "available_channels",
    "versions"
})

public class Connections__1 {

    @JsonProperty("comments")
    private Comments comments;
    @JsonProperty("credits")
    private Credits credits;
    @JsonProperty("likes")
    private Likes likes;
    @JsonProperty("pictures")
    private Pictures__2 pictures;
    @JsonProperty("texttracks")
    private Texttracks texttracks;
    @JsonProperty("related")
    private Related related;
    @JsonProperty("recommendations")
    private Recommendations recommendations;
    @JsonProperty("albums")
    private Albums albums;
    @JsonProperty("available_albums")
    private AvailableAlbums availableAlbums;
    @JsonProperty("available_channels")
    private AvailableChannels availableChannels;
    @JsonProperty("versions")
    private Versions versions;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("comments")
    public Comments getComments() {
        return comments;
    }

    @JsonProperty("comments")
    public void setComments(Comments comments) {
        this.comments = comments;
    }

    @JsonProperty("credits")
    public Credits getCredits() {
        return credits;
    }

    @JsonProperty("credits")
    public void setCredits(Credits credits) {
        this.credits = credits;
    }

    @JsonProperty("likes")
    public Likes getLikes() {
        return likes;
    }

    @JsonProperty("likes")
    public void setLikes(Likes likes) {
        this.likes = likes;
    }

    @JsonProperty("pictures")
    public Pictures__2 getPictures() {
        return pictures;
    }

    @JsonProperty("pictures")
    public void setPictures(Pictures__2 pictures) {
        this.pictures = pictures;
    }

    @JsonProperty("texttracks")
    public Texttracks getTexttracks() {
        return texttracks;
    }

    @JsonProperty("texttracks")
    public void setTexttracks(Texttracks texttracks) {
        this.texttracks = texttracks;
    }

    @JsonProperty("related")
    public Related getRelated() {
        return related;
    }

    @JsonProperty("related")
    public void setRelated(Related related) {
        this.related = related;
    }

    @JsonProperty("recommendations")
    public Recommendations getRecommendations() {
        return recommendations;
    }

    @JsonProperty("recommendations")
    public void setRecommendations(Recommendations recommendations) {
        this.recommendations = recommendations;
    }

    @JsonProperty("albums")
    public Albums getAlbums() {
        return albums;
    }

    @JsonProperty("albums")
    public void setAlbums(Albums albums) {
        this.albums = albums;
    }

    @JsonProperty("available_albums")
    public AvailableAlbums getAvailableAlbums() {
        return availableAlbums;
    }

    @JsonProperty("available_albums")
    public void setAvailableAlbums(AvailableAlbums availableAlbums) {
        this.availableAlbums = availableAlbums;
    }

    @JsonProperty("available_channels")
    public AvailableChannels getAvailableChannels() {
        return availableChannels;
    }

    @JsonProperty("available_channels")
    public void setAvailableChannels(AvailableChannels availableChannels) {
        this.availableChannels = availableChannels;
    }

    @JsonProperty("versions")
    public Versions getVersions() {
        return versions;
    }

    @JsonProperty("versions")
    public void setVersions(Versions versions) {
        this.versions = versions;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Connections__1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("comments");
        sb.append('=');
        sb.append(((this.comments == null)?"<null>":this.comments));
        sb.append(',');
        sb.append("credits");
        sb.append('=');
        sb.append(((this.credits == null)?"<null>":this.credits));
        sb.append(',');
        sb.append("likes");
        sb.append('=');
        sb.append(((this.likes == null)?"<null>":this.likes));
        sb.append(',');
        sb.append("pictures");
        sb.append('=');
        sb.append(((this.pictures == null)?"<null>":this.pictures));
        sb.append(',');
        sb.append("texttracks");
        sb.append('=');
        sb.append(((this.texttracks == null)?"<null>":this.texttracks));
        sb.append(',');
        sb.append("related");
        sb.append('=');
        sb.append(((this.related == null)?"<null>":this.related));
        sb.append(',');
        sb.append("recommendations");
        sb.append('=');
        sb.append(((this.recommendations == null)?"<null>":this.recommendations));
        sb.append(',');
        sb.append("albums");
        sb.append('=');
        sb.append(((this.albums == null)?"<null>":this.albums));
        sb.append(',');
        sb.append("availableAlbums");
        sb.append('=');
        sb.append(((this.availableAlbums == null)?"<null>":this.availableAlbums));
        sb.append(',');
        sb.append("availableChannels");
        sb.append('=');
        sb.append(((this.availableChannels == null)?"<null>":this.availableChannels));
        sb.append(',');
        sb.append("versions");
        sb.append('=');
        sb.append(((this.versions == null)?"<null>":this.versions));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
