package servicebox.web.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import servicebox.web.blog.service.PostService;

/**
 * @author John Spangenberg
 */
@Controller
@RequestMapping("/posts")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("posts", postService.list());
        return "post/list";
    }

    @RequestMapping("/view/{slug}")
    public String view(@PathVariable(value="slug") String slug, Model model){
        model.addAttribute("post", postService.getBySLug(slug));
        return "post/view";
    }


}
