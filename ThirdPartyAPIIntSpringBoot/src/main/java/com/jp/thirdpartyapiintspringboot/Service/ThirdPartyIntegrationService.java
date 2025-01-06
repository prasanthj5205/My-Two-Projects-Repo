package com.jp.thirdpartyapiintspringboot.Service;

import com.jp.thirdpartyapiintspringboot.model.User;
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

@Service
public class ThirdPartyIntegrationService {

    @Autowired
    private RestTemplate restTemplate;

    String baseUrl = "https://jsonplaceholder.typicode.com/";
    StringBuilder string = new StringBuilder(baseUrl);
    public List<User> getAllPosts() {
        HttpEntity entity = new HttpEntity(getHeaders());
        String url = string.append("/posts").toString();
        return restTemplate.exchange(url, HttpMethod.GET,entity, List.class).getBody();
    }

    public HttpHeaders getHeaders() {
        String sample="sample in new branch";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return headers;
    }
}
