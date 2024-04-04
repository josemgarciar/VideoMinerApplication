
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
    "normal",
    "best_of_the_month",
    "best_of_the_year",
    "premiere"
})

public class StaffPick {

    @JsonProperty("normal")
    private Boolean normal;
    @JsonProperty("best_of_the_month")
    private Boolean bestOfTheMonth;
    @JsonProperty("best_of_the_year")
    private Boolean bestOfTheYear;
    @JsonProperty("premiere")
    private Boolean premiere;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("normal")
    public Boolean getNormal() {
        return normal;
    }

    @JsonProperty("normal")
    public void setNormal(Boolean normal) {
        this.normal = normal;
    }

    @JsonProperty("best_of_the_month")
    public Boolean getBestOfTheMonth() {
        return bestOfTheMonth;
    }

    @JsonProperty("best_of_the_month")
    public void setBestOfTheMonth(Boolean bestOfTheMonth) {
        this.bestOfTheMonth = bestOfTheMonth;
    }

    @JsonProperty("best_of_the_year")
    public Boolean getBestOfTheYear() {
        return bestOfTheYear;
    }

    @JsonProperty("best_of_the_year")
    public void setBestOfTheYear(Boolean bestOfTheYear) {
        this.bestOfTheYear = bestOfTheYear;
    }

    @JsonProperty("premiere")
    public Boolean getPremiere() {
        return premiere;
    }

    @JsonProperty("premiere")
    public void setPremiere(Boolean premiere) {
        this.premiere = premiere;
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
        sb.append(StaffPick.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("normal");
        sb.append('=');
        sb.append(((this.normal == null)?"<null>":this.normal));
        sb.append(',');
        sb.append("bestOfTheMonth");
        sb.append('=');
        sb.append(((this.bestOfTheMonth == null)?"<null>":this.bestOfTheMonth));
        sb.append(',');
        sb.append("bestOfTheYear");
        sb.append('=');
        sb.append(((this.bestOfTheYear == null)?"<null>":this.bestOfTheYear));
        sb.append(',');
        sb.append("premiere");
        sb.append('=');
        sb.append(((this.premiere == null)?"<null>":this.premiere));
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
