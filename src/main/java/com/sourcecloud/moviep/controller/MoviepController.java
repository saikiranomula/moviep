package com.sourcecloud.moviep.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sourcecloud.moviep.model.Moviep;
import com.sourcecloud.moviep.service.MoviepService;


@RestController
@RequestMapping("/movie")
public class MoviepController {

	
	@Autowired
	private MoviepService moviepService; 
	
    @GetMapping
	public List<Moviep> getMoviep(@RequestParam(required=false) String LeadActor) {
		
		List<Moviep> movieps = moviepService.getMovieps();
		
		List<Moviep> filterMovieps = new ArrayList<Moviep>();
		
		if(LeadActor == null) {
			filterMovieps.addAll(movieps);
		} else {
			for (Moviep moviep : movieps) {
				if(LeadActor.equalsIgnoreCase(moviep.getLeadActor())) {
					filterMovieps.add(moviep);
				}
			}
		}
		
		
		return filterMovieps;
		
	}
	
	
	
	//@PostMapping
//	public void createStudent(@RequestBody Student student) {
		
	//	 studentService.insertStudent(student);
		
	//	 List<Student>FilteredStudent = new ArrayList<Student>();
	//}
	
//	@PutMapping
//	public void updateStudent(@RequestBody Student student) {
		
//	}
	
	
}
