package com.sourcecloud.moviep.dao;

import java.util.List;

import com.sourcecloud.moviep.model.Director;





public interface DirectorDao {
	
	List<Director> getDirectors();
	
	void createDirector(Director director);
	
	void updateDirector(Director director);
	

}
