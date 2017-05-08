package servicebox.blog.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import servicebox.blog.domain.Author;

/**
 * @author John Spangenberg
 */
public interface AuthorRepository extends PagingAndSortingRepository<Author, Long> {
}
