
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
    "watchlater",
    "like",
    "report",
    "can_update_privacy_to_public",
    "validate"
})

public class Interactions {

    @JsonProperty("watchlater")
    private Watchlater watchlater;
    @JsonProperty("like")
    private Like like;
    @JsonProperty("report")
    private Report report;
    @JsonProperty("can_update_privacy_to_public")
    private CanUpdatePrivacyToPublic canUpdatePrivacyToPublic;
    @JsonProperty("validate")
    private Validate validate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("watchlater")
    public Watchlater getWatchlater() {
        return watchlater;
    }

    @JsonProperty("watchlater")
    public void setWatchlater(Watchlater watchlater) {
        this.watchlater = watchlater;
    }

    @JsonProperty("like")
    public Like getLike() {
        return like;
    }

    @JsonProperty("like")
    public void setLike(Like like) {
        this.like = like;
    }

    @JsonProperty("report")
    public Report getReport() {
        return report;
    }

    @JsonProperty("report")
    public void setReport(Report report) {
        this.report = report;
    }

    @JsonProperty("can_update_privacy_to_public")
    public CanUpdatePrivacyToPublic getCanUpdatePrivacyToPublic() {
        return canUpdatePrivacyToPublic;
    }

    @JsonProperty("can_update_privacy_to_public")
    public void setCanUpdatePrivacyToPublic(CanUpdatePrivacyToPublic canUpdatePrivacyToPublic) {
        this.canUpdatePrivacyToPublic = canUpdatePrivacyToPublic;
    }

    @JsonProperty("validate")
    public Validate getValidate() {
        return validate;
    }

    @JsonProperty("validate")
    public void setValidate(Validate validate) {
        this.validate = validate;
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
        sb.append(Interactions.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("watchlater");
        sb.append('=');
        sb.append(((this.watchlater == null)?"<null>":this.watchlater));
        sb.append(',');
        sb.append("like");
        sb.append('=');
        sb.append(((this.like == null)?"<null>":this.like));
        sb.append(',');
        sb.append("report");
        sb.append('=');
        sb.append(((this.report == null)?"<null>":this.report));
        sb.append(',');
        sb.append("canUpdatePrivacyToPublic");
        sb.append('=');
        sb.append(((this.canUpdatePrivacyToPublic == null)?"<null>":this.canUpdatePrivacyToPublic));
        sb.append(',');
        sb.append("validate");
        sb.append('=');
        sb.append(((this.validate == null)?"<null>":this.validate));
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
