
package com.sourcecloud.moviep.dao.impl;



import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Component;

import com.sourcecloud.moviep.dao.MoviepDao;
import com.sourcecloud.moviep.model.Moviep;



@Component
public class MoviepDaoImpl implements MoviepDao {

	@Autowired
	private JdbcTemplate moviepTemplate;
	
	
	public List<Moviep> getMovies() {
		
		List<Moviep> movieps = new ArrayList<Moviep>();
		
		
		List<Map<String, Object>> rows =  moviepTemplate.queryForList("SELECT * FROM MOVIEP");
		
		for (Map<String, Object> row : rows) {
			
			Moviep mv = new Moviep();
			mv.setId((Integer)(row.get("ID")));
			mv.setName((String)row.get("NAME"));
			mv.setReleaseDate((String)row.get("ReleaseDate"));
			mv.setLeadActor((String)row.get("LeadActor"));
			mv.setLeadActress((String)row.get("LeadActress"));
			mv.setDirector((String)row.get("MoviepDao"));
			mv.setProdectionHouse((String)row.get("ProdectionHouse"));
			movieps.add(mv);
		}
		
				
		
		
		return movieps;
	}

	
	public void createMoviep(final Moviep moviep) {
		
		String sql = "INSERT INTO MOVIEP VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		moviepTemplate.execute(sql, new PreparedStatementCallback<Boolean>(){

			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1,moviep.getId());  
		        ps.setString(2,moviep.getName());  
		        ps.setString(3,moviep.getReleaseDate()); 
		        ps.setString(4,moviep.getLeadActor());
		        ps.setString(5,moviep.getLeadActress());
		        ps.setString(4,moviep.getDirector());
		        ps.setString(4,moviep.getProdectionHouse());
		        return ps.execute();  
			}
		    
			

			  
		    });  
		
		

	}
	
	
	

	public void updateMoviep(Moviep moviep) {
		// TODO Auto-generated method stub
		
	}


	
}