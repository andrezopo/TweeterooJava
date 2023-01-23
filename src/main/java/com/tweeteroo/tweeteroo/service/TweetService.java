package com.tweeteroo.tweeteroo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tweeteroo.tweeteroo.model.Person;
import com.tweeteroo.tweeteroo.model.Tweet;
import com.tweeteroo.tweeteroo.repository.PersonRepository;
import com.tweeteroo.tweeteroo.repository.TweetRepository;
import com.tweeteroo.tweeteroo.types.TweetUsername;

@Service
public class TweetService {
    
    @Autowired
    private TweetRepository tweetRepository;

    @Autowired
    private PersonRepository personRepository;

    public void createTweet(TweetUsername data) {
        List<Person> user = personRepository.findByUsername(data.username);
        if (!user.isEmpty()){
            Tweet tweet = new Tweet();
            tweet.setText(data.tweet);
            tweet.setUser(user.get(0));
            tweetRepository.save(tweet);
        }
        
    }

    public Page<Tweet> findAll(Pageable pageable) {
        return tweetRepository.findAll(pageable);
    }
}
