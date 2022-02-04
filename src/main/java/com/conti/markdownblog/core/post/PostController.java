package com.conti.markdownblog.core.post;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/posts")
@NoArgsConstructor
public class PostController {

    @Autowired
    private PostRepository postRepository;

    private final static int PAGINATION_SIZE = 3;

    @GetMapping("")
    public String getPaginatePosts(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "" + PAGINATION_SIZE) int size,
            Model model) {

        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"));
        Page postsPage = postRepository.findAll(pageRequest);
        List<Post> posts = postsPage.toList();

        long postCount = postRepository.count();
        int numOfPages = (int) Math.ceil((postCount * 1.0) / PAGINATION_SIZE);

        model.addAttribute("posts", posts);
        model.addAttribute("postCount", postCount);
        model.addAttribute("pageRequested", page);
        // todo paginationSize check
        model.addAttribute("paginationSize", PAGINATION_SIZE);
        model.addAttribute("numOfPages", numOfPages);
        return "posts";
    }

    @GetMapping("/{id}")
    public String getPostById(@PathVariable long id, Model model) {

        Optional<Post> postOptional = postRepository.findById(id);
        if (postOptional.isPresent()) {
            model.addAttribute("post", postOptional.get());
        } else {
            model.addAttribute("error", "no-post");
        }
        return "post";
    }


}
