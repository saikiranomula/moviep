package com.sourcecloud.moviep.dao;

import java.util.List;

import com.sourcecloud.moviep.model.Moviep;


public interface MoviepDao {

	List<Moviep> getMovies();
	
	void createMoviep(Moviep moviep);
	
	void updateMoviep(Moviep moviep);
	
	
}
