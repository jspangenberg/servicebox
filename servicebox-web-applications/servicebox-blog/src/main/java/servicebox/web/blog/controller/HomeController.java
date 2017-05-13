package servicebox.web.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import servicebox.web.blog.service.PostService;

/**
 * @author John Spangenberg
 */
@Controller
public class HomeController {

    private PostService postService;

    @Autowired
    public HomeController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("post", postService.getLatestPost());
        return "index";
    }
}
