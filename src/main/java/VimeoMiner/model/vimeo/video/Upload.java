
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
    "status",
    "link",
    "upload_link",
    "form",
    "approach",
    "size",
    "redirect_url"
})

public class Upload {

    @JsonProperty("status")
    private String status;
    @JsonProperty("link")
    private Object link;
    @JsonProperty("upload_link")
    private Object uploadLink;
    @JsonProperty("form")
    private Object form;
    @JsonProperty("approach")
    private Object approach;
    @JsonProperty("size")
    private Object size;
    @JsonProperty("redirect_url")
    private Object redirectUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("link")
    public Object getLink() {
        return link;
    }

    @JsonProperty("link")
    public void setLink(Object link) {
        this.link = link;
    }

    @JsonProperty("upload_link")
    public Object getUploadLink() {
        return uploadLink;
    }

    @JsonProperty("upload_link")
    public void setUploadLink(Object uploadLink) {
        this.uploadLink = uploadLink;
    }

    @JsonProperty("form")
    public Object getForm() {
        return form;
    }

    @JsonProperty("form")
    public void setForm(Object form) {
        this.form = form;
    }

    @JsonProperty("approach")
    public Object getApproach() {
        return approach;
    }

    @JsonProperty("approach")
    public void setApproach(Object approach) {
        this.approach = approach;
    }

    @JsonProperty("size")
    public Object getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(Object size) {
        this.size = size;
    }

    @JsonProperty("redirect_url")
    public Object getRedirectUrl() {
        return redirectUrl;
    }

    @JsonProperty("redirect_url")
    public void setRedirectUrl(Object redirectUrl) {
        this.redirectUrl = redirectUrl;
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
        sb.append(Upload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("link");
        sb.append('=');
        sb.append(((this.link == null)?"<null>":this.link));
        sb.append(',');
        sb.append("uploadLink");
        sb.append('=');
        sb.append(((this.uploadLink == null)?"<null>":this.uploadLink));
        sb.append(',');
        sb.append("form");
        sb.append('=');
        sb.append(((this.form == null)?"<null>":this.form));
        sb.append(',');
        sb.append("approach");
        sb.append('=');
        sb.append(((this.approach == null)?"<null>":this.approach));
        sb.append(',');
        sb.append("size");
        sb.append('=');
        sb.append(((this.size == null)?"<null>":this.size));
        sb.append(',');
        sb.append("redirectUrl");
        sb.append('=');
        sb.append(((this.redirectUrl == null)?"<null>":this.redirectUrl));
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
