package servicebox.web.blog.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import servicebox.web.blog.domain.Author;
import servicebox.web.blog.domain.Post;


/**
 * @author John Spangenberg
 */
@Service
public class PostService {

    @Value("${blog.service.endpoint}")
    private String blogServiceUrl;

    private RestTemplate restTemplate;

    public PostService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public Post getLatestPost() {
        String url = blogServiceUrl + "/search/findFirstByOrderByPostedOnDesc";

        ResponseEntity<Resource<Post>> blogPostResponseEntity
                = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<Resource<Post>>() {
        });

        Resource<Post> blogPostResource = blogPostResponseEntity.getBody();
        Post blogPost = blogPostResource.getContent();
        blogPost.setAuthor(getAuthor(restTemplate,blogPostResource.getLink("author")));

        return blogPost;
    }

    private Author getAuthor(RestTemplate restTemplate, Link authorLink) {
        Author author = null;
        if (authorLink != null) {
            ResponseEntity<Resource<Author>> authorResponseEntity
                    = restTemplate.exchange(authorLink.getHref(), HttpMethod.GET, null, new ParameterizedTypeReference<Resource<Author>>() {
            });

            Resource<Author> authorResource = authorResponseEntity.getBody();
            author = authorResource.getContent();
        }
        return author;
    }

}
