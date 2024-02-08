package com.stackroute.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.domain.Blog;
import com.stackroute.exception.BlogAlreadyExistsException;
import com.stackroute.exception.BlogNotFoundException;
/* This is ServiceImplementation Class which should implement BlogService Interface and override all the implemented methods.
 * Handle suitable exceptions for all the implemented methods*/
import com.stackroute.repository.BlogRepository;

@Service
public class BlogServiceImpl implements BlogService  {
	
	@Autowired
	BlogRepository blogRepository;

	@Override
	public Blog saveBlog(Blog blog) throws BlogAlreadyExistsException{
		// TODO Auto-generated method stub
		Optional<Blog> existingBlog = blogRepository.findById(blog.getBlogId());
		if(existingBlog.isPresent()) {
			throw new BlogAlreadyExistsException("Blog Already Exists");
		}
		return blogRepository.save(blog);
	}

	@Override
	public List<Blog> getAllBlogs() {
		// TODO Auto-generated method stub
		Iterable<Blog> allBlogs = blogRepository.findAll();
		return (List<Blog>) allBlogs;
	}

	@Override
	public Blog getBlogById(int id) throws BlogNotFoundException{
		// TODO Auto-generated method stub
		Optional<Blog> blog= blogRepository.findById(id);
		if(blog.isEmpty()) {
			throw new BlogNotFoundException("Blog Not Found");
		}
		blogRepository.findById(id);
		return blog.get();
	}

	@Override
	public Blog deleteBlog(int id) throws BlogNotFoundException {
		// TODO Auto-generated method stub
		Optional<Blog> blog = blogRepository.findById(id);
		if(blog.isEmpty()) {
			throw new BlogNotFoundException("blog not found");
		}
		blogRepository.findById(id);
		blogRepository.deleteById(id);
		return blog.get();
	}

	@Override
	public Blog updateBlog(Blog blog) throws BlogNotFoundException {
		// TODO Auto-generated method stub
		if(!blogRepository.existsById(blog.getBlogId())) {
			throw new BlogNotFoundException("blog not found");
		}
		Optional<Blog> existingBlog = blogRepository.findById(blog.getBlogId());
		return blogRepository.save(blog);
	}

}

