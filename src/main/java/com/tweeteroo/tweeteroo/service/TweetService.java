package com.tweeteroo.tweeteroo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tweeteroo.tweeteroo.dto.TweetDTO;
import com.tweeteroo.tweeteroo.model.Person;
import com.tweeteroo.tweeteroo.model.Tweet;
import com.tweeteroo.tweeteroo.repository.PersonRepository;
import com.tweeteroo.tweeteroo.repository.TweetRepository;

@Service
public class TweetService {
    
    @Autowired
    private TweetRepository tweetRepository;

    @Autowired
    private PersonRepository personRepository;

    public boolean createTweet(String username , TweetDTO req) {
        List<Person> user = personRepository.findByUsername(username);
        try {
            if (!user.isEmpty()){
                Tweet tweet = new Tweet(user.get(0), req.text());
                tweetRepository.save(tweet);
                return true;
            }
        } catch (Exception e) {
            return false;
        }

        return true;

        
    }

    public Page<Tweet> findAll(Pageable pageable) {
         return tweetRepository.findAll(pageable);
    }

    public List<Tweet> findByUsername(String username){
        List<Tweet> userTweets = tweetRepository.findByUsernameOrderByIdDesc(username);

        if (userTweets.isEmpty()){
            return List.of();
        }

        return userTweets;

    }
}
