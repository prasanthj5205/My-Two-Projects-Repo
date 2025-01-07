package com.jp.thirdpartyapiintspringboot.Service;

import com.jp.thirdpartyapiintspringboot.model.User;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.lang.model.type.ArrayType;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class ThirdPartyIntegrationService {

    @Autowired
    private RestTemplate restTemplate;

    String baseUrl = "https://jsonplaceholder.typicode.com/";
    public List<User> getAllPosts() {
        String POST = "/posts";
        HttpEntity entity = new HttpEntity(getHeaders());
        String url = baseUrl+"/posts";
        return restTemplate.exchange(url, HttpMethod.GET,entity, List.class).getBody();
    }

    public HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return headers;
    }

    public User getPostById(int id) {
        HttpEntity entity = new HttpEntity(getHeaders());
        String url = baseUrl+ "/posts/" + id;
         return restTemplate.exchange(url, HttpMethod.GET,entity, User.class).getBody();

    }

    public User insertPosts(User user) {
        HttpEntity entity = new HttpEntity(user,getHeaders());
        String url = baseUrl+ "/posts";
        return restTemplate.exchange(url, HttpMethod.POST,entity, User.class).getBody();
    }

    public User updatePosts(User user, int id) {
        HttpEntity entity = new HttpEntity(user,getHeaders());
        String url = baseUrl+ "/posts/"+ id;;
        return restTemplate.exchange(url, HttpMethod.PUT,entity, User.class).getBody();
    }

    public Map deletePosts(int id) {
        HttpEntity entity = new HttpEntity(getHeaders());
        String url = baseUrl+ "/posts/"+ id;;
        return restTemplate.exchange(url, HttpMethod.DELETE,entity, Map.class).getBody();
    }
}
