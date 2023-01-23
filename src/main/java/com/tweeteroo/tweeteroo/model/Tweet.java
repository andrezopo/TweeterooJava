package com.tweeteroo.tweeteroo.model;

import com.tweeteroo.tweeteroo.dto.TweetDTO;
import com.tweeteroo.tweeteroo.types.PersonTweet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Tweet {

    public Tweet(Person user, String text){
        this.text = text;
        this.user = user;
    }

    public Tweet (TweetDTO data){
        this.text = data.text();
    }
    public Tweet (){
        
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 500, nullable = false, name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "username")
    private Person user;
}
