package com.sourcecloud.moviep.service;

import java.util.List;

import com.sourcecloud.moviep.model.Director;



public interface DirectorService {

	List<Director> getDirectors();
	
	void insertDirector(Director director);
	
	
}
