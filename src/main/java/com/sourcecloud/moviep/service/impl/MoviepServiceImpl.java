package com.sourcecloud.moviep.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sourcecloud.moviep.dao.MoviepDao;
import com.sourcecloud.moviep.model.Moviep;
import com.sourcecloud.moviep.service.MoviepService;

@Component
public class MoviepServiceImpl implements MoviepService {

	@Autowired
	private MoviepDao moviepDao;

	
	public List<Moviep> getMovieps() {
		List<Moviep> movieps = moviepDao.getMovies();
		
		return movieps;
		
		
	}

	public void insertMovieps(Moviep moviep) {
		moviepDao.createMoviep(moviep);
		
	}







}
