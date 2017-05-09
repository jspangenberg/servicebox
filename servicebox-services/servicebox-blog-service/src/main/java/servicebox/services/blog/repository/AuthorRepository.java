package servicebox.services.blog.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import servicebox.services.blog.domain.Author;

/**
 * @author John Spangenberg
 */
public interface AuthorRepository extends PagingAndSortingRepository<Author, Long> {
}
