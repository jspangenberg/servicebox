package servicebox.services.blog.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import servicebox.services.blog.domain.Post;

import java.util.List;

/**
 * @author John Spangenberg
 */
public interface PostRepository extends PagingAndSortingRepository<Post, Long> {

    List<Post> findByTitleContaining(@Param("title") String title);
}
