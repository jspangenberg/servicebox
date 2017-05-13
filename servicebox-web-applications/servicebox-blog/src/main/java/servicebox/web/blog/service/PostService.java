package servicebox.web.blog.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import servicebox.web.blog.domain.Post;

/**
 * @author John Spangenberg
 */
@Service
public class PostService {

    @Value("${blog.service.endpoint}")
    private String blogServiceUrl;

    public Post getLatestPost() {
        RestTemplate restTemplate = new RestTemplate();


        return restTemplate.getForObject(blogServiceUrl + "/search/findFirstByOrderByPostedOnDesc", Post.class);
    }

}
