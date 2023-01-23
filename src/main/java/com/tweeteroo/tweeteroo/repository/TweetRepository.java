package com.tweeteroo.tweeteroo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tweeteroo.tweeteroo.model.Person;
import com.tweeteroo.tweeteroo.model.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

    Page<Tweet> findAll(Pageable pageable);
    public List<Tweet> findByUser(Person user);


}
