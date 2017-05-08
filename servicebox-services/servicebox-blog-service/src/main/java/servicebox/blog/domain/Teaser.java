package servicebox.blog.domain;

import org.springframework.data.rest.core.config.Projection;

/**
 * @author John Spangenberg
 */
@Projection(name = "teaser", types = {Post.class})
public interface Teaser {

    String getTitle();

    String getSlug();

    String getTeaser();

}
