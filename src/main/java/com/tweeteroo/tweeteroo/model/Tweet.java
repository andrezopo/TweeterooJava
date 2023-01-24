package com.tweeteroo.tweeteroo.model;

import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCreation;

import org.hibernate.type.descriptor.jdbc.BigIntJdbcType;
import org.hibernate.validator.constraints.URL;
import org.springframework.data.annotation.CreatedDate;

import com.tweeteroo.tweeteroo.dto.TweetDTO;
import com.tweeteroo.tweeteroo.types.PersonTweet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tweets")
public class Tweet {

    public Tweet(Person user, String text){
        this.text = text;
        this.username = user.getUsername();
        this.avatar = user.getAvatar();
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

    @Column
    private String username;

    @Column
    @URL
    private String avatar;
}
