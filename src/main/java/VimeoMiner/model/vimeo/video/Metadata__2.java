
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
    "interactions"
})

public class Metadata__2 {

    @JsonProperty("connections")
    private Connections__2 connections;
    @JsonProperty("interactions")
    private Interactions__1 interactions;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("connections")
    public Connections__2 getConnections() {
        return connections;
    }

    @JsonProperty("connections")
    public void setConnections(Connections__2 connections) {
        this.connections = connections;
    }

    @JsonProperty("interactions")
    public Interactions__1 getInteractions() {
        return interactions;
    }

    @JsonProperty("interactions")
    public void setInteractions(Interactions__1 interactions) {
        this.interactions = interactions;
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
        sb.append(Metadata__2 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("connections");
        sb.append('=');
        sb.append(((this.connections == null)?"<null>":this.connections));
        sb.append(',');
        sb.append("interactions");
        sb.append('=');
        sb.append(((this.interactions == null)?"<null>":this.interactions));
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
