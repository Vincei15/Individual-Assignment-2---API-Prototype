package com.csc340.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/dog")
public class DogImageController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/random")
    public String getRandomDogImage() {
        String apiUrl = "https://dog.ceo/api/breeds/image/random";

        DogObject Dog = restTemplate.getForObject(apiUrl, DogObject.class);

        return "<html><body><h2>Random Dog Image</h2>"
                + "<img src='" + Dog.getMessage() + "' style='max-width: 500px; border-radius: 10px;'/>"
                + "</body></html>";
    }
}