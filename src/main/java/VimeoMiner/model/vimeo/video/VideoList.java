
package VimeoMiner.model.vimeo.video;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VideoList {

    @JsonProperty("total")
    private Integer total;
    @JsonProperty("data")
    private List<Video> data;

    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Integer total) {
        this.total = total;
    }

    @JsonProperty("data")
    public List<Video> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<Video> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(VideoList.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("total");
        sb.append('=');
        sb.append(((this.total == null)?"<null>":this.total));
        sb.append(',');
        sb.append("data");
        sb.append('=');
        sb.append(((this.data == null)?"<null>":this.data));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
