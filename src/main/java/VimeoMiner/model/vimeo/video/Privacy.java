
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
    "view",
    "embed",
    "download",
    "add",
    "comments"
})

public class Privacy {

    @JsonProperty("view")
    private String view;
    @JsonProperty("embed")
    private String embed;
    @JsonProperty("download")
    private Boolean download;
    @JsonProperty("add")
    private Boolean add;
    @JsonProperty("comments")
    private String comments;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("view")
    public String getView() {
        return view;
    }

    @JsonProperty("view")
    public void setView(String view) {
        this.view = view;
    }

    @JsonProperty("embed")
    public String getEmbed() {
        return embed;
    }

    @JsonProperty("embed")
    public void setEmbed(String embed) {
        this.embed = embed;
    }

    @JsonProperty("download")
    public Boolean getDownload() {
        return download;
    }

    @JsonProperty("download")
    public void setDownload(Boolean download) {
        this.download = download;
    }

    @JsonProperty("add")
    public Boolean getAdd() {
        return add;
    }

    @JsonProperty("add")
    public void setAdd(Boolean add) {
        this.add = add;
    }

    @JsonProperty("comments")
    public String getComments() {
        return comments;
    }

    @JsonProperty("comments")
    public void setComments(String comments) {
        this.comments = comments;
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
        sb.append(Privacy.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("view");
        sb.append('=');
        sb.append(((this.view == null)?"<null>":this.view));
        sb.append(',');
        sb.append("embed");
        sb.append('=');
        sb.append(((this.embed == null)?"<null>":this.embed));
        sb.append(',');
        sb.append("download");
        sb.append('=');
        sb.append(((this.download == null)?"<null>":this.download));
        sb.append(',');
        sb.append("add");
        sb.append('=');
        sb.append(((this.add == null)?"<null>":this.add));
        sb.append(',');
        sb.append("comments");
        sb.append('=');
        sb.append(((this.comments == null)?"<null>":this.comments));
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
