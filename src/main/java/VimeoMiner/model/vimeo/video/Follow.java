
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
    "added",
    "added_time",
    "uri",
    "options"
})

public class Follow {

    @JsonProperty("added")
    private Boolean added;
    @JsonProperty("added_time")
    private Object addedTime;
    @JsonProperty("uri")
    private String uri;
    @JsonProperty("options")
    private List<String> options;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("added")
    public Boolean getAdded() {
        return added;
    }

    @JsonProperty("added")
    public void setAdded(Boolean added) {
        this.added = added;
    }

    @JsonProperty("added_time")
    public Object getAddedTime() {
        return addedTime;
    }

    @JsonProperty("added_time")
    public void setAddedTime(Object addedTime) {
        this.addedTime = addedTime;
    }

    @JsonProperty("uri")
    public String getUri() {
        return uri;
    }

    @JsonProperty("uri")
    public void setUri(String uri) {
        this.uri = uri;
    }

    @JsonProperty("options")
    public List<String> getOptions() {
        return options;
    }

    @JsonProperty("options")
    public void setOptions(List<String> options) {
        this.options = options;
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
        sb.append(Follow.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("added");
        sb.append('=');
        sb.append(((this.added == null)?"<null>":this.added));
        sb.append(',');
        sb.append("addedTime");
        sb.append('=');
        sb.append(((this.addedTime == null)?"<null>":this.addedTime));
        sb.append(',');
        sb.append("uri");
        sb.append('=');
        sb.append(((this.uri == null)?"<null>":this.uri));
        sb.append(',');
        sb.append("options");
        sb.append('=');
        sb.append(((this.options == null)?"<null>":this.options));
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
