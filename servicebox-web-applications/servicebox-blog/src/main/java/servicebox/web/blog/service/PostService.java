package servicebox.web.blog.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import servicebox.web.blog.domain.Post;

/**
 * @author John Spangenberg
 */
@Service
public class PostService {

    public Post getLatestPost() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8081/posts/search/findFirstByOrderByPostedOnDesc", Post.class);
    }

}
