package com.sourcecloud.moviep.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sourcecloud.moviep.dao.DirectorDao;
import com.sourcecloud.moviep.model.Director;
import com.sourcecloud.moviep.service.DirectorService;

@Component
public class DriectorServiceImpl implements DirectorService {

	@Autowired
	private DirectorDao directorDao;

	
	public List<Director> getDirectors() {
		List<Director> directors = directorDao.getDirectors();
		
		return directors;
		
	}

	public void insertDirector(Director director) {
		directorDao.createDirector(director);
		
	}







}
