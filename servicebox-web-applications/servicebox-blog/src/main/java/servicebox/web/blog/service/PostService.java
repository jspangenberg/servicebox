package servicebox.web.blog.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.hateoas.mvc.TypeConstrainedMappingJackson2HttpMessageConverter;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import servicebox.web.blog.domain.Post;
import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author John Spangenberg
 */
@Service
public class PostService {

    @Value("${blog.service.endpoint}")
    private String blogServiceUrl;

    public Post getLatestPost() {
        RestTemplate restTemplate = getRestTemplateWithHalMessageConverter();
       // return restTemplate.getForObject(blogServiceUrl + "/search/findFirstByOrderByPostedOnDesc", Post.class);
        String url = blogServiceUrl + "/search/findFirstByOrderByPostedOnDesc";
        ResponseEntity<Resource<Post>> blogPostResponseEntity
                = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<Resource<Post>>() {
        });

        Resource<Post> blogPostResource = blogPostResponseEntity.getBody();

        Link authorLink = blogPostResource.getLink("author");
        String authorURI = authorLink.getHref();

        Post blogPost = blogPostResource.getContent();
        return blogPost;
    }


    private HttpMessageConverter getHalMessageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new Jackson2HalModule());
        MappingJackson2HttpMessageConverter halConverter = new TypeConstrainedMappingJackson2HttpMessageConverter(ResourceSupport.class);

        //halConverter.setSupportedMediaTypes(Arrays.asList(new MediaType(MediaType.APPLICATION_JSON.getType())));
        halConverter.setSupportedMediaTypes(Arrays.asList(MediaTypes.HAL_JSON));
        halConverter.setObjectMapper(objectMapper);
        return halConverter;
    }

    public RestTemplate getRestTemplateWithHalMessageConverter() {
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> existingConverters = restTemplate.getMessageConverters();
        List<HttpMessageConverter<?>> newConverters = new ArrayList<>();
        newConverters.add(getHalMessageConverter());
        newConverters.addAll(existingConverters);
        restTemplate.setMessageConverters(newConverters);
        return restTemplate;
    }



}
