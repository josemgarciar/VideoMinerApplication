
package VimeoMiner.model.vimeo.video;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "uri",
    "name",
    "link",
    "capabilities",
    "location",
    "gender",
    "bio",
    "short_bio",
    "created_time",
    "pictures",
    "websites",
    "metadata",
    "location_details",
    "skills",
    "available_for_hire",
    "can_work_remotely",
    "resource_key",
    "account"
})

public class User {

    @JsonProperty("uri")
    private String uri;
    @JsonProperty("name")
    private String name;
    @JsonProperty("link")
    private String link;
    @JsonProperty("capabilities")
    private Capabilities capabilities;
    @JsonProperty("location")
    private String location;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("bio")
    private String bio;
    @JsonProperty("short_bio")
    private String shortBio;
    @JsonProperty("created_time")
    private String createdTime;
    @JsonProperty("pictures")
    private Pictures__3 pictures;
    @JsonProperty("websites")
    private List<Website> websites;
    @JsonProperty("metadata")
    private Metadata__2 metadata;
    @JsonProperty("location_details")
    private LocationDetails locationDetails;
    @JsonProperty("skills")
    private List<Object> skills;
    @JsonProperty("available_for_hire")
    private Boolean availableForHire;
    @JsonProperty("can_work_remotely")
    private Boolean canWorkRemotely;
    @JsonProperty("resource_key")
    private String resourceKey;
    @JsonProperty("account")
    private String account;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

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

    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
    }

    @JsonProperty("capabilities")
    public Capabilities getCapabilities() {
        return capabilities;
    }

    @JsonProperty("capabilities")
    public void setCapabilities(Capabilities capabilities) {
        this.capabilities = capabilities;
    }

    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonProperty("bio")
    public String getBio() {
        return bio;
    }

    @JsonProperty("bio")
    public void setBio(String bio) {
        this.bio = bio;
    }

    @JsonProperty("short_bio")
    public String getShortBio() {
        return shortBio;
    }

    @JsonProperty("short_bio")
    public void setShortBio(String shortBio) {
        this.shortBio = shortBio;
    }

    @JsonProperty("created_time")
    public String getCreatedTime() {
        return createdTime;
    }

    @JsonProperty("created_time")
    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    @JsonProperty("pictures")
    public Pictures__3 getPictures() {
        return pictures;
    }

    @JsonProperty("pictures")
    public void setPictures(Pictures__3 pictures) {
        this.pictures = pictures;
    }

    @JsonProperty("websites")
    public List<Website> getWebsites() {
        return websites;
    }

    @JsonProperty("websites")
    public void setWebsites(List<Website> websites) {
        this.websites = websites;
    }

    @JsonProperty("metadata")
    public Metadata__2 getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(Metadata__2 metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("location_details")
    public LocationDetails getLocationDetails() {
        return locationDetails;
    }

    @JsonProperty("location_details")
    public void setLocationDetails(LocationDetails locationDetails) {
        this.locationDetails = locationDetails;
    }

    @JsonProperty("skills")
    public List<Object> getSkills() {
        return skills;
    }

    @JsonProperty("skills")
    public void setSkills(List<Object> skills) {
        this.skills = skills;
    }

    @JsonProperty("available_for_hire")
    public Boolean getAvailableForHire() {
        return availableForHire;
    }

    @JsonProperty("available_for_hire")
    public void setAvailableForHire(Boolean availableForHire) {
        this.availableForHire = availableForHire;
    }

    @JsonProperty("can_work_remotely")
    public Boolean getCanWorkRemotely() {
        return canWorkRemotely;
    }

    @JsonProperty("can_work_remotely")
    public void setCanWorkRemotely(Boolean canWorkRemotely) {
        this.canWorkRemotely = canWorkRemotely;
    }

    @JsonProperty("resource_key")
    public String getResourceKey() {
        return resourceKey;
    }

    @JsonProperty("resource_key")
    public void setResourceKey(String resourceKey) {
        this.resourceKey = resourceKey;
    }

    @JsonProperty("account")
    public String getAccount() {
        return account;
    }

    @JsonProperty("account")
    public void setAccount(String account) {
        this.account = account;
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
        sb.append(User.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("uri");
        sb.append('=');
        sb.append(((this.uri == null)?"<null>":this.uri));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("link");
        sb.append('=');
        sb.append(((this.link == null)?"<null>":this.link));
        sb.append(',');
        sb.append("capabilities");
        sb.append('=');
        sb.append(((this.capabilities == null)?"<null>":this.capabilities));
        sb.append(',');
        sb.append("location");
        sb.append('=');
        sb.append(((this.location == null)?"<null>":this.location));
        sb.append(',');
        sb.append("gender");
        sb.append('=');
        sb.append(((this.gender == null)?"<null>":this.gender));
        sb.append(',');
        sb.append("bio");
        sb.append('=');
        sb.append(((this.bio == null)?"<null>":this.bio));
        sb.append(',');
        sb.append("shortBio");
        sb.append('=');
        sb.append(((this.shortBio == null)?"<null>":this.shortBio));
        sb.append(',');
        sb.append("createdTime");
        sb.append('=');
        sb.append(((this.createdTime == null)?"<null>":this.createdTime));
        sb.append(',');
        sb.append("pictures");
        sb.append('=');
        sb.append(((this.pictures == null)?"<null>":this.pictures));
        sb.append(',');
        sb.append("websites");
        sb.append('=');
        sb.append(((this.websites == null)?"<null>":this.websites));
        sb.append(',');
        sb.append("metadata");
        sb.append('=');
        sb.append(((this.metadata == null)?"<null>":this.metadata));
        sb.append(',');
        sb.append("locationDetails");
        sb.append('=');
        sb.append(((this.locationDetails == null)?"<null>":this.locationDetails));
        sb.append(',');
        sb.append("skills");
        sb.append('=');
        sb.append(((this.skills == null)?"<null>":this.skills));
        sb.append(',');
        sb.append("availableForHire");
        sb.append('=');
        sb.append(((this.availableForHire == null)?"<null>":this.availableForHire));
        sb.append(',');
        sb.append("canWorkRemotely");
        sb.append('=');
        sb.append(((this.canWorkRemotely == null)?"<null>":this.canWorkRemotely));
        sb.append(',');
        sb.append("resourceKey");
        sb.append('=');
        sb.append(((this.resourceKey == null)?"<null>":this.resourceKey));
        sb.append(',');
        sb.append("account");
        sb.append('=');
        sb.append(((this.account == null)?"<null>":this.account));
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
