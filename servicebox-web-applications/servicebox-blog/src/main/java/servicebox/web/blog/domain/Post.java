package servicebox.web.blog.domain;

import java.util.Date;

/**
 * @author John Spangenberg
 */
public class Post {


    private String title;
    private String body;
    private String teaser;
    private String slug;
    private Date postedOn;

    public Post() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTeaser() {
        return teaser;
    }

    public void setTeaser(String teaser) {
        this.teaser = teaser;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Date getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(Date postedOn) {
        this.postedOn = postedOn;
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", teaser='" + teaser + '\'' +
                ", slug='" + slug + '\'' +
                ", postedOn=" + postedOn +
                '}';
    }
}
