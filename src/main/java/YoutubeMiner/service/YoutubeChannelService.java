package YoutubeMiner.service;

import YoutubeMiner.model.channel.Channel;
import YoutubeMiner.model.channel.ChannelSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class YoutubeChannelService {

    RestTemplate restTemplate = new RestTemplate();

    String baseUri = "https://www.googleapis.com/youtube/v3/channels?key=AIzaSyBSCMH5ASLuIxXKRN-_AV0ExAY_pr7GDiQ&forUsername=Willyrex&part=snippet";

    public VideoMiner.model.Channel getChannel() {
        HttpHeaders header = new HttpHeaders();
        HttpEntity<ChannelSearch> request = new HttpEntity<>(null, header);
        ResponseEntity<ChannelSearch> response = restTemplate.exchange(baseUri, HttpMethod.GET, request, ChannelSearch.class);

        if (response == null) {
            return null;
        } else {
            return convertToDBChannel(response.getBody());
        }
    }

    private VideoMiner.model.Channel convertToDBChannel(ChannelSearch channelSearch) {
        VideoMiner.model.Channel channel = new VideoMiner.model.Channel();
        channel.setId(channelSearch.getItems().get(0).getId());
        channel.setName(channelSearch.getItems().get(0).getSnippet().getTitle());
        channel.setDescription(channelSearch.getItems().get(0).getSnippet().getDescription());
        channel.setCreatedTime(channelSearch.getItems().get(0).getSnippet().getPublishedAt());
        return channel;
    }
}
