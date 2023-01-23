package com.tweeteroo.tweeteroo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweeteroo.tweeteroo.model.Tweet;
import com.tweeteroo.tweeteroo.service.TweetService;
import com.tweeteroo.tweeteroo.types.TweetUsername;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TweetController {

    @Autowired
    private TweetService tweetService;


    
    @PostMapping("/tweets")
    public ResponseEntity<String> createTweet(@RequestBody TweetUsername req){
        tweetService.createTweet(req);
        return ResponseEntity.status(201).body("Tweet criado com sucesso!");
    }

    @GetMapping("/tweets")
    @CrossOrigin
    public Page<Tweet> listAllTweets(
            @PageableDefault(size = 5, page = 0)
            @RequestParam int page
        ) {
        Pageable paging = PageRequest.of(page, 5);    
        return tweetService.findAll(paging);
    }


}
