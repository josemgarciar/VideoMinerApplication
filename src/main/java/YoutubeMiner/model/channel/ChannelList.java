
package YoutubeMiner.model.channel;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "kind",
    "etag",
    "pageInfo",
    "items"
})

public class ChannelList {
    @JsonProperty("items")
    private List<Channel> items;

    @JsonProperty("items")
    public List<Channel> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<Channel> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ChannelList.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');

        sb.append("items");
        sb.append('=');
        sb.append(((this.items == null)?"<null>":this.items));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
