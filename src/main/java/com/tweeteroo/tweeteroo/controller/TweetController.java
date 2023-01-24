package com.tweeteroo.tweeteroo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweeteroo.tweeteroo.dto.TweetDTO;
import com.tweeteroo.tweeteroo.model.Tweet;
import com.tweeteroo.tweeteroo.service.TweetService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TweetController {

    @Autowired
    private TweetService tweetService;


    
    @PostMapping("/tweets")
    public ResponseEntity<String> createTweet(@RequestBody TweetDTO req, @RequestHeader("user") String username){
        if (tweetService.createTweet(username, req)){
            return ResponseEntity.status(201).body("Tweet criado com sucesso!");
        }else {
            return ResponseEntity.status(500).body("Não foi possível criar o tweet!");
        }
        
    }

    @GetMapping("/tweets")
    @CrossOrigin
    public Page<Tweet> listAllTweets(
            @PageableDefault(size = 5, page = 0)
            @RequestParam int page
        ) {
        Pageable paging = PageRequest.of(page, 5, Sort.by(Direction.DESC, "id"));
        return tweetService.findAll(paging);
    }

    @GetMapping("/tweets/{username}")
    public List<Tweet> listByUsername(
        @PageableDefault(size = 5, page = 0)
        @PathVariable String username) {
            return tweetService.findByUsername(username);
        }


}
