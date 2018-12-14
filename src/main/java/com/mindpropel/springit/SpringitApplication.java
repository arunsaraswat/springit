package com.mindpropel.springit;

import com.mindpropel.springit.domain.Comment;
import com.mindpropel.springit.domain.Link;
import com.mindpropel.springit.repository.CommentRepository;
import com.mindpropel.springit.repository.LinkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
@EnableJpaAuditing
public class SpringitApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringitApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringitApplication.class, args);
    }

    //@Bean
    CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository) {
        return args -> {
            Link link = new Link("Getting started with Spring Boot 2", "https://google.com");
            linkRepository.save(link);

            Comment comment = new Comment("This Spring Boot 2 link is awesome", link);
            comment.setBody("This Spring Boot 2 link is awesome");
            commentRepository.save(comment);

            link.addComment(comment);

            System.out.println("========================");
            System.out.println(" We just created tables and inserted into link and comment");

        };
    }
}
