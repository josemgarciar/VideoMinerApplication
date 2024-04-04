
package VimeoMiner.model.vimeo.video;

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
    "albums",
    "appearances",
    "channels",
    "feed",
    "followers",
    "following",
    "groups",
    "likes",
    "membership",
    "moderated_channels",
    "portfolios",
    "videos",
    "shared",
    "pictures",
    "folders_root",
    "teams",
    "permission_policies"
})

public class Connections__2 {

    @JsonProperty("albums")
    private Albums__1 albums;
    @JsonProperty("appearances")
    private Appearances appearances;
    @JsonProperty("channels")
    private Channels channels;
    @JsonProperty("feed")
    private Feed feed;
    @JsonProperty("followers")
    private Followers followers;
    @JsonProperty("following")
    private Following following;
    @JsonProperty("groups")
    private Groups groups;
    @JsonProperty("likes")
    private Likes__1 likes;
    @JsonProperty("membership")
    private Membership membership;
    @JsonProperty("moderated_channels")
    private ModeratedChannels moderatedChannels;
    @JsonProperty("portfolios")
    private Portfolios portfolios;
    @JsonProperty("videos")
    private Videos__1 videos;
    @JsonProperty("shared")
    private Shared shared;
    @JsonProperty("pictures")
    private Pictures__4 pictures;
    @JsonProperty("folders_root")
    private FoldersRoot foldersRoot;
    @JsonProperty("teams")
    private Teams teams;
    @JsonProperty("permission_policies")
    private PermissionPolicies permissionPolicies;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("albums")
    public Albums__1 getAlbums() {
        return albums;
    }

    @JsonProperty("albums")
    public void setAlbums(Albums__1 albums) {
        this.albums = albums;
    }

    @JsonProperty("appearances")
    public Appearances getAppearances() {
        return appearances;
    }

    @JsonProperty("appearances")
    public void setAppearances(Appearances appearances) {
        this.appearances = appearances;
    }

    @JsonProperty("channels")
    public Channels getChannels() {
        return channels;
    }

    @JsonProperty("channels")
    public void setChannels(Channels channels) {
        this.channels = channels;
    }

    @JsonProperty("feed")
    public Feed getFeed() {
        return feed;
    }

    @JsonProperty("feed")
    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    @JsonProperty("followers")
    public Followers getFollowers() {
        return followers;
    }

    @JsonProperty("followers")
    public void setFollowers(Followers followers) {
        this.followers = followers;
    }

    @JsonProperty("following")
    public Following getFollowing() {
        return following;
    }

    @JsonProperty("following")
    public void setFollowing(Following following) {
        this.following = following;
    }

    @JsonProperty("groups")
    public Groups getGroups() {
        return groups;
    }

    @JsonProperty("groups")
    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    @JsonProperty("likes")
    public Likes__1 getLikes() {
        return likes;
    }

    @JsonProperty("likes")
    public void setLikes(Likes__1 likes) {
        this.likes = likes;
    }

    @JsonProperty("membership")
    public Membership getMembership() {
        return membership;
    }

    @JsonProperty("membership")
    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    @JsonProperty("moderated_channels")
    public ModeratedChannels getModeratedChannels() {
        return moderatedChannels;
    }

    @JsonProperty("moderated_channels")
    public void setModeratedChannels(ModeratedChannels moderatedChannels) {
        this.moderatedChannels = moderatedChannels;
    }

    @JsonProperty("portfolios")
    public Portfolios getPortfolios() {
        return portfolios;
    }

    @JsonProperty("portfolios")
    public void setPortfolios(Portfolios portfolios) {
        this.portfolios = portfolios;
    }

    @JsonProperty("videos")
    public Videos__1 getVideos() {
        return videos;
    }

    @JsonProperty("videos")
    public void setVideos(Videos__1 videos) {
        this.videos = videos;
    }

    @JsonProperty("shared")
    public Shared getShared() {
        return shared;
    }

    @JsonProperty("shared")
    public void setShared(Shared shared) {
        this.shared = shared;
    }

    @JsonProperty("pictures")
    public Pictures__4 getPictures() {
        return pictures;
    }

    @JsonProperty("pictures")
    public void setPictures(Pictures__4 pictures) {
        this.pictures = pictures;
    }

    @JsonProperty("folders_root")
    public FoldersRoot getFoldersRoot() {
        return foldersRoot;
    }

    @JsonProperty("folders_root")
    public void setFoldersRoot(FoldersRoot foldersRoot) {
        this.foldersRoot = foldersRoot;
    }

    @JsonProperty("teams")
    public Teams getTeams() {
        return teams;
    }

    @JsonProperty("teams")
    public void setTeams(Teams teams) {
        this.teams = teams;
    }

    @JsonProperty("permission_policies")
    public PermissionPolicies getPermissionPolicies() {
        return permissionPolicies;
    }

    @JsonProperty("permission_policies")
    public void setPermissionPolicies(PermissionPolicies permissionPolicies) {
        this.permissionPolicies = permissionPolicies;
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
        sb.append(Connections__2 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("albums");
        sb.append('=');
        sb.append(((this.albums == null)?"<null>":this.albums));
        sb.append(',');
        sb.append("appearances");
        sb.append('=');
        sb.append(((this.appearances == null)?"<null>":this.appearances));
        sb.append(',');
        sb.append("channels");
        sb.append('=');
        sb.append(((this.channels == null)?"<null>":this.channels));
        sb.append(',');
        sb.append("feed");
        sb.append('=');
        sb.append(((this.feed == null)?"<null>":this.feed));
        sb.append(',');
        sb.append("followers");
        sb.append('=');
        sb.append(((this.followers == null)?"<null>":this.followers));
        sb.append(',');
        sb.append("following");
        sb.append('=');
        sb.append(((this.following == null)?"<null>":this.following));
        sb.append(',');
        sb.append("groups");
        sb.append('=');
        sb.append(((this.groups == null)?"<null>":this.groups));
        sb.append(',');
        sb.append("likes");
        sb.append('=');
        sb.append(((this.likes == null)?"<null>":this.likes));
        sb.append(',');
        sb.append("membership");
        sb.append('=');
        sb.append(((this.membership == null)?"<null>":this.membership));
        sb.append(',');
        sb.append("moderatedChannels");
        sb.append('=');
        sb.append(((this.moderatedChannels == null)?"<null>":this.moderatedChannels));
        sb.append(',');
        sb.append("portfolios");
        sb.append('=');
        sb.append(((this.portfolios == null)?"<null>":this.portfolios));
        sb.append(',');
        sb.append("videos");
        sb.append('=');
        sb.append(((this.videos == null)?"<null>":this.videos));
        sb.append(',');
        sb.append("shared");
        sb.append('=');
        sb.append(((this.shared == null)?"<null>":this.shared));
        sb.append(',');
        sb.append("pictures");
        sb.append('=');
        sb.append(((this.pictures == null)?"<null>":this.pictures));
        sb.append(',');
        sb.append("foldersRoot");
        sb.append('=');
        sb.append(((this.foldersRoot == null)?"<null>":this.foldersRoot));
        sb.append(',');
        sb.append("teams");
        sb.append('=');
        sb.append(((this.teams == null)?"<null>":this.teams));
        sb.append(',');
        sb.append("permissionPolicies");
        sb.append('=');
        sb.append(((this.permissionPolicies == null)?"<null>":this.permissionPolicies));
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
