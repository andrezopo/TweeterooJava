package com.tweeteroo.tweeteroo.repository;

import java.util.List;

import org.hibernate.annotations.OrderBy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tweeteroo.tweeteroo.model.Person;
import com.tweeteroo.tweeteroo.model.Tweet;
import com.tweeteroo.tweeteroo.types.CompleteTweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

    
    Page<Tweet> findAll(Pageable pageable);
    
    
    
    List<Tweet> findByUsername(String username);
    
    List<Tweet> findByUsernameOrderByIdDesc(String username);

    


}
