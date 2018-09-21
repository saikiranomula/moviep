package com.sourcecloud.moviep.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sourcecloud.moviep.model.Director;
import com.sourcecloud.moviep.service.DirectorService;




@RestController
@RequestMapping("/director")
public class DirectorController {

	
	
	@Autowired
	private DirectorService directorService; 
	
    @GetMapping
	public List<Director> getDirector(@RequestParam(required=false) String LeadActor) {
		
		List<Director> directors = directorService.getDirectors();
		
		List<Director> filterDirector = new ArrayList<Director>();
		
		if(LeadActor == null) {
			filterDirector.addAll(directors);
		} else {
			
			
			for (Director director1 : directors) {
				if(LeadActor.equalsIgnoreCase(director1.getLeadActor())) {
					filterDirector.add(director1);
				}
			}
		}
		
		
		return filterDirector;
		
	}
}