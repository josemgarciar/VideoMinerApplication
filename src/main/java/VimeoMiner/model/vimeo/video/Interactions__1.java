
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
    "follow",
    "block",
    "report"
})

public class Interactions__1 {

    @JsonProperty("follow")
    private Follow follow;
    @JsonProperty("block")
    private Block block;
    @JsonProperty("report")
    private Report__1 report;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("follow")
    public Follow getFollow() {
        return follow;
    }

    @JsonProperty("follow")
    public void setFollow(Follow follow) {
        this.follow = follow;
    }

    @JsonProperty("block")
    public Block getBlock() {
        return block;
    }

    @JsonProperty("block")
    public void setBlock(Block block) {
        this.block = block;
    }

    @JsonProperty("report")
    public Report__1 getReport() {
        return report;
    }

    @JsonProperty("report")
    public void setReport(Report__1 report) {
        this.report = report;
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
        sb.append(Interactions__1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("follow");
        sb.append('=');
        sb.append(((this.follow == null)?"<null>":this.follow));
        sb.append(',');
        sb.append("block");
        sb.append('=');
        sb.append(((this.block == null)?"<null>":this.block));
        sb.append(',');
        sb.append("report");
        sb.append('=');
        sb.append(((this.report == null)?"<null>":this.report));
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
