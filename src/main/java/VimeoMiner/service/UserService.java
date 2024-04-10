package VimeoMiner.service;

import VimeoMiner.model.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import VimeoMiner.model.user.User;
@Service
public class UserService {
    @Autowired
    RestTemplate restTemplate;
    String baseUri = "https://api.vimeo.com/users/adultswim";
    String token = "152307b18fa3949c3591a895137abe8e";

    public User getUser() {
        HttpHeaders header = new HttpHeaders();
        header.set("Authorization", "bearer " + token);
        HttpEntity<User> request = new HttpEntity<>(null, header);

        ResponseEntity<User> response = restTemplate.exchange(baseUri, HttpMethod.GET, request, User.class);
        return response.getBody();
    }
}