package servicebox.services.blog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import servicebox.services.blog.domain.Author;
import servicebox.services.blog.domain.Post;
import servicebox.services.blog.repository.AuthorRepository;
import servicebox.services.blog.repository.PostRepository;

import java.util.Date;

/**
 * @author John Spangenberg
 */

@SpringBootApplication
public class BlogServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(AuthorRepository authorRepository, PostRepository postRepository) {
        return args -> {

            Author dv = new Author("John","Spangenberg","ja.spangenberg@gmail.com");
            authorRepository.save( dv );

            Post post = new Post("Spring Boot Rocks!");
            post.setSlug("spring-data-rocks");
            post.setTeaser("Post Teaser");
            post.setBody("Post Body");
            post.setPostedOn(new Date());
            post.setAuthor(dv);
            postRepository.save(post);

            Post rest = new Post("REST is what all the cool kids are doing");
            rest.setSlug("rest-is-cool");
            rest.setTeaser("REST Teaser");
            rest.setBody("REST BODY");
            rest.setPostedOn(new Date());
            rest.setAuthor(dv);
            postRepository.save(rest);

        };
    }


}
