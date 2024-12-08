package com.paul.Clients;

import com.paul.Models.GenreResponse;
import com.paul.Models.MovieByIdResponse;
import com.paul.Models.MovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class MovieClientImpl implements MovieClient{

    private final RestTemplate restTemplate;
    private final static String SORT_BY_POPULARITY = "popularity.desc";
    private final static String APPEND_TO_RESPONSE = "append_to_response";
    private final static String VIDEOS = "videos";
    @Value("${api.base-url}")
    private String baseUrl;

    @Value("${api.search-movie}")
    private String searchMovieUrl;

    @Value("${api.genre}")
    private String genreUrl;

    @Value("${api.language-EN}")
    private String languageEN;

    @Value("${api.discover-movie}")
    private String discoverMovieUrl;

    @Value("${api.id}")
    private String idUrl;

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

    public GenreResponse getGenres() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + authToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String requestUrl = UriComponentsBuilder
                .fromHttpUrl(genreUrl)
                .queryParam("language", languageEN)
                .toUriString();

        ResponseEntity<GenreResponse> response = restTemplate.exchange(
                requestUrl,
                HttpMethod.GET,
                entity,
                GenreResponse.class
        );
        return response.getBody();
    }

    public MovieResponse getMoviesByPopularity() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + authToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String requestUrl = UriComponentsBuilder
                .fromHttpUrl(discoverMovieUrl)
                .queryParam("include_adult", false)
                .queryParam("page", 1)
                .queryParam("sort_by", "popularity.desc")
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

    public MovieResponse getMoviesByGenre(int genreId) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + authToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String requestUrl = UriComponentsBuilder
                .fromHttpUrl(discoverMovieUrl)
                .queryParam("include_adult", true)
                .queryParam("page", 1)
                .queryParam("with_genres", genreId)
                .queryParam("sort_by", SORT_BY_POPULARITY)
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

    public MovieByIdResponse getMovieById(int id) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + authToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String requestUrl = UriComponentsBuilder
                .fromHttpUrl(idUrl)
                .queryParam("language", languageEN)
                .queryParam(APPEND_TO_RESPONSE, VIDEOS)
                .path(Integer.toString(id))
                .toUriString();

        ResponseEntity<MovieByIdResponse> response = restTemplate.exchange(
                requestUrl,
                HttpMethod.GET,
                entity,
                MovieByIdResponse.class
        );
        return response.getBody();
    }
}
