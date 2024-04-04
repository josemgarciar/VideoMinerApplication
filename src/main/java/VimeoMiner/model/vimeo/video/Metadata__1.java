
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
    "connections",
    "interactions",
    "is_vimeo_create",
    "is_screen_record"
})

public class Metadata__1 {

    @JsonProperty("connections")
    private Connections__1 connections;
    @JsonProperty("interactions")
    private Interactions interactions;
    @JsonProperty("is_vimeo_create")
    private Boolean isVimeoCreate;
    @JsonProperty("is_screen_record")
    private Boolean isScreenRecord;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("connections")
    public Connections__1 getConnections() {
        return connections;
    }

    @JsonProperty("connections")
    public void setConnections(Connections__1 connections) {
        this.connections = connections;
    }

    @JsonProperty("interactions")
    public Interactions getInteractions() {
        return interactions;
    }

    @JsonProperty("interactions")
    public void setInteractions(Interactions interactions) {
        this.interactions = interactions;
    }

    @JsonProperty("is_vimeo_create")
    public Boolean getIsVimeoCreate() {
        return isVimeoCreate;
    }

    @JsonProperty("is_vimeo_create")
    public void setIsVimeoCreate(Boolean isVimeoCreate) {
        this.isVimeoCreate = isVimeoCreate;
    }

    @JsonProperty("is_screen_record")
    public Boolean getIsScreenRecord() {
        return isScreenRecord;
    }

    @JsonProperty("is_screen_record")
    public void setIsScreenRecord(Boolean isScreenRecord) {
        this.isScreenRecord = isScreenRecord;
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
        sb.append(Metadata__1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("connections");
        sb.append('=');
        sb.append(((this.connections == null)?"<null>":this.connections));
        sb.append(',');
        sb.append("interactions");
        sb.append('=');
        sb.append(((this.interactions == null)?"<null>":this.interactions));
        sb.append(',');
        sb.append("isVimeoCreate");
        sb.append('=');
        sb.append(((this.isVimeoCreate == null)?"<null>":this.isVimeoCreate));
        sb.append(',');
        sb.append("isScreenRecord");
        sb.append('=');
        sb.append(((this.isScreenRecord == null)?"<null>":this.isScreenRecord));
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
