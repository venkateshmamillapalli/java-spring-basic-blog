package com.pluralsight.blog;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pluralsight.blog.data.PostRepository;
import com.pluralsight.blog.model.Post;

@Controller
public class BlogController {
	
	private PostRepository postRepository;
	
	public BlogController(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@RequestMapping("/")
	public String listPosts(ModelMap map) {
		List<Post> posts = postRepository.getAllPosts();
		
		map.put("title","Blog Post 1");
		map.put("posts",posts);
		
		return "home";
	}
	
	@RequestMapping("/post/{id}")
	public String postDetails(@PathVariable Long id, ModelMap ModelMap) {
		
		Post post = postRepository.findById(id);
		ModelMap.put("post", post);
		return "post-details";
		
	}
}
