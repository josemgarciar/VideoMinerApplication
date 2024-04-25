package VimeoMiner.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("https://api.vimeo.com/channels/{id}/videos")
public class VideoController {

    /*
     JRP: The controllers and repositories class don`t belong to VimeoMiner/YoutubeMiner,
     they belong to VideoMiner. We cant just switch these classes to the VideoMiner package
     and call it a day
     */
}
