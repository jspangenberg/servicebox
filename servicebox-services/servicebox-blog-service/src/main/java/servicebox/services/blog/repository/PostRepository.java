package servicebox.services.blog.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import servicebox.services.blog.domain.Post;

import java.util.List;

/**
 * @author John Spangenberg
 */
public interface PostRepository extends PagingAndSortingRepository<Post, Long> {

    Post findFirstByOrderByPostedOnDesc();

    List<Post> findAllByOrderByPostedOnDesc();

    Post findBySlug(@Param("slug") String slug);

    List<Post> findAllByAuthorIdOrderByPostedOnDesc(Long id);

    List<Post> findByTitleContaining(@Param("title") String title);
}
