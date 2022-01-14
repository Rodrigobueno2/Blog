package com.spring.codeblog.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.repository.CodeblogRepository;

@Component
public class dummyData {
	@Autowired
	CodeblogRepository codeBlogRepository;
	
	//@PostConstruct
	public void savePost() {
		List<Post> postList = new ArrayList<>();
		Post post1 = new Post();
		post1.setAutor("Rodrigo");
		post1.setData(LocalDate.now());
		post1.setTitulo("Java");
		post1.setTexto("Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos");
		
		Post post2 = new Post();
		post2.setAutor("Rodrigo");
		post2.setData(LocalDate.now());
		post2.setTitulo("Spring boot");
		post2.setTexto("Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos");
	
		postList.add(post2);
		postList.add(post1);
		
			for(Post post:postList) {
				Post p = codeBlogRepository.save(post);
			}
		
	}
}
