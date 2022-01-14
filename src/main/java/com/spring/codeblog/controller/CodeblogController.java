package com.spring.codeblog.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.method.annotation.ViewNameMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.service.CodeblogService;

@Controller
@RequestMapping(value = "/posts")
public class CodeblogController {
	@Autowired
	CodeblogService codeblogService;
	
	@GetMapping
	public ModelAndView getPosts() {
		ModelAndView mv = new ModelAndView("posts");
		List<Post> posts = codeblogService.findAll();
		mv.addObject("posts", posts);
		return mv;
	}
	
	@GetMapping("/{id}")
	public ModelAndView getPostDetails(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("postDetails");
		Post post = codeblogService.findById(id);
		mv.addObject("post", post);
		return mv;
	}
	
	@GetMapping("/newpost")
	public String getPostForm() {
		return "postForm";
	}
	
	@PostMapping("/newpost")
	public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifiquem se os campos obrigatorios foram preenchidos!");
			return "redirect:/posts/newpost";
		}
		
		post.setData(LocalDate.now());
		codeblogService.save(post);
		return "redirect:/posts";
	}
	
}
