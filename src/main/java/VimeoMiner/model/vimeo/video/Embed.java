
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
    "html",
    "badges",
    "interactive"
})

public class Embed {

    @JsonProperty("html")
    private String html;
    @JsonProperty("badges")
    private Badges badges;
    @JsonProperty("interactive")
    private Boolean interactive;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("html")
    public String getHtml() {
        return html;
    }

    @JsonProperty("html")
    public void setHtml(String html) {
        this.html = html;
    }

    @JsonProperty("badges")
    public Badges getBadges() {
        return badges;
    }

    @JsonProperty("badges")
    public void setBadges(Badges badges) {
        this.badges = badges;
    }

    @JsonProperty("interactive")
    public Boolean getInteractive() {
        return interactive;
    }

    @JsonProperty("interactive")
    public void setInteractive(Boolean interactive) {
        this.interactive = interactive;
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
        sb.append(Embed.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("html");
        sb.append('=');
        sb.append(((this.html == null)?"<null>":this.html));
        sb.append(',');
        sb.append("badges");
        sb.append('=');
        sb.append(((this.badges == null)?"<null>":this.badges));
        sb.append(',');
        sb.append("interactive");
        sb.append('=');
        sb.append(((this.interactive == null)?"<null>":this.interactive));
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
