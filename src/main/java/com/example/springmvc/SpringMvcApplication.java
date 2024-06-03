package com.example.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@SpringBootApplication
@RestController
public class SpringMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcApplication.class, args);
    }

    @GetMapping("/posts/{id}")
    public Map<String, String> getPosts(@PathVariable Long id) throws Exception {

        Thread.sleep(300);
        if(id > 10L) {
            throw new Exception("Too Long...");
        }
        return Map.of("id", id.toString(),
                "content", "Posts content is %d".formatted(id));
    }
}
