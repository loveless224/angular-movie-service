package com.paul.Clients;

import com.paul.Models.Movie;
import com.paul.Models.MovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;

@Service
public class MovieClientImpl implements MovieClient{

    private final RestTemplate restTemplate;
    @Value("${api.base-url}")
    private String baseUrl;

    @Value("${api.search-movie}")
    private String searchMovieUrl;

    @Value("${api.language-EN}")
    private String languageEN;

    @Value("${api.token}")
    private String authToken;

    @Autowired
    public MovieClientImpl(RestTemplateBuilder restTemplate) {
        this.restTemplate = restTemplate.build();
    }

    public MovieResponse getMovieByTitle(String title) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + authToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String requestUrl = UriComponentsBuilder
                .fromHttpUrl(searchMovieUrl)
                .queryParam("query", title)
                .queryParam("language", languageEN)
                .toUriString();

        ResponseEntity<MovieResponse> response = restTemplate.exchange(
                requestUrl,
                HttpMethod.GET,
                entity,
                MovieResponse.class
        );
        return response.getBody();
    }
}
